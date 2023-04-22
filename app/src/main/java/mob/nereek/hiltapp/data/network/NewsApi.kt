package mob.nereek.hiltapp.data.network

import mob.nereek.hiltapp.BuildConfig
import mob.nereek.hiltapp.data.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

        @GET("top-headlines")
        suspend fun getTopHeadlines(
            @Query("apiKey") apiKey: String = BuildConfig.APINEWS_KEY,
            @Query("country") country: String
        ): Response<NewsResponse>

}
