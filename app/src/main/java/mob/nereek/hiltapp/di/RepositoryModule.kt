package mob.nereek.hiltapp.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import mob.nereek.hiltapp.data.network.ApiHelper
import mob.nereek.hiltapp.data.network.ApiHelperImpl
import mob.nereek.hiltapp.data.repository.NewsRepository
import mob.nereek.hiltapp.data.repository.NewsRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    // Provides an instance of ApiHelper interface
    @Provides
    fun provideApiHelper(apiHelperImpl: ApiHelperImpl): ApiHelper {
        return apiHelperImpl
    }

    // Provides an instance of NewsRepository interface
    @Provides
    fun provideNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository {
        return newsRepositoryImpl
    }

}