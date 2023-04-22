package mob.nereek.hiltapp.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mob.nereek.hiltapp.data.model.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: NewsApi
):ApiHelper {

    /**
     * This function retrieves the top headlines news from the NewsAPI endpoint
     * for a given country and authorization token.
     * @param token Authorization token to access the NewsAPI endpoint
     * @param country Country code for which to retrieve the news
     * @return A Retrofit response object containing the news response from the endpoint
     */
    override suspend fun getTopHeadlines(token: String, country: String): Response<NewsResponse> {
        return withContext(Dispatchers.IO) {
            apiService.getTopHeadlines(token, country)
        }
    }

}