package mob.nereek.hiltapp.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import mob.nereek.hiltapp.common.base.Resource
import mob.nereek.hiltapp.data.model.Article
import mob.nereek.hiltapp.data.network.ApiHelperImpl
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val apiHelper: ApiHelperImpl // inject the ApiHelperImpl instance
): NewsRepository {
    override suspend fun getNews(token: String, country: String): Flow<Resource<List<Article>>> {
        return flow {
            emit(Resource.Loading()) // emit loading state

            // call the getTopHeadlines API method
            val newsResponse = apiHelper.getTopHeadlines(token, country)

            if (newsResponse.isSuccessful) { // check if the response is successful
                val filteredArticles = newsResponse.body()?.articles/*?.filter {
                    it.title != null && it.urlToImage != null
                }*/
                if (filteredArticles != null) {
                    emit(Resource.Success(filteredArticles)) // emit success state with filtered articles
                } else {
                    emit(Resource.Error("Error filtering articles"))
                }
            } else {
                emit(Resource.Error("Error fetching news")) // emit error state
            }
        }.catch { e ->
            emit(Resource.Error(e.message.toString())) // catch and emit any exception as error state
        }.flowOn(Dispatchers.IO) // run the flow on the IO dispatcher
    }
}