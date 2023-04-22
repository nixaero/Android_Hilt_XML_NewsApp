package mob.nereek.hiltapp.ui.newslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mob.nereek.hiltapp.BuildConfig
import mob.nereek.hiltapp.common.base.Resource
import mob.nereek.hiltapp.data.model.Article
import mob.nereek.hiltapp.data.repository.NewsRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepositoryImpl
) : ViewModel() {

    // Private LiveData for articles list
    private val _news = MutableLiveData<Resource<List<Article>>>()
    // Public LiveData for articles list that can only be observed externally
    val news: LiveData<Resource<List<Article>>> = _news

    // Private LiveData for selected country
    private val _country = MutableLiveData<String>("us")
    // Public LiveData for selected country that can only be observed externally
    val country: LiveData<String> = _country

    // Function to update selected country
    fun setCountry(country: String) {
        _country.value = country
    }

    // Function to get news for selected country
    fun getNews() {
        // Use viewModelScope to launch a coroutine that will automatically be cancelled when the ViewModel is cleared
        viewModelScope.launch {
            // Collect the news from the repository using the selected country
            newsRepository.getNews(BuildConfig.APINEWS_KEY, _country.value!!)
                .collect { resource ->
                    // Update the private LiveData with the result from the repository
                    _news.value = resource
                }
        }
    }
}