package mob.nereek.hiltapp.data.repository

import kotlinx.coroutines.flow.Flow
import mob.nereek.hiltapp.common.base.Resource
import mob.nereek.hiltapp.data.model.Article

interface NewsRepository {
    suspend fun getNews(token: String, country: String): Flow<Resource<List<Article>>>
}
