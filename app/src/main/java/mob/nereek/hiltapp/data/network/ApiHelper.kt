package mob.nereek.hiltapp.data.network

import mob.nereek.hiltapp.data.model.NewsResponse
import retrofit2.Response

interface ApiHelper {


    suspend fun getTopHeadlines(token: String, country: String): Response<NewsResponse>

}