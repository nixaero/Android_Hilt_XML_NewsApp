package mob.nereek.hiltapp.ui.newslist

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import mob.nereek.hiltapp.BuildConfig
import mob.nereek.hiltapp.R
import mob.nereek.hiltapp.common.base.Resource
import mob.nereek.hiltapp.databinding.NewsListFragmentBinding
import mob.nereek.hiltapp.common.utils.network.NetworkUtils
import mob.nereek.hiltapp.common.utils.ui.MessageUtils
import mob.nereek.hiltapp.ui.newslist.adapter.NewsListAdapter
import javax.inject.Inject

@AndroidEntryPoint
class NewsListFragment : Fragment(R.layout.news_list_fragment) {

    private lateinit var binding: NewsListFragmentBinding
    private val viewModel: NewsViewModel by viewModels()

    // Use constructor injection for adapter and network utils
    @Inject
    lateinit var adapter: NewsListAdapter
    @Inject
    lateinit var networkUtils: NetworkUtils

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = NewsListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize views
        initViews()

        // Observe news list
        observeNewsList()

        // Fetch news list
        fetchNewsList()

        // Setup country selection
        setupCountrySelection()
    }

    private fun initViews() {
        // Set up the RecyclerView with the adapter
        binding.newsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@NewsListFragment.adapter
        }
        // Set up the SwipeRefreshLayout
        binding.swipeRefreshLayout.setOnRefreshListener {
            fetchNewsList()
        }
    }

    private fun observeNewsList() {
        // Observe the news LiveData in the ViewModel
        viewModel.news.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                // On success, update the adapter with the new list of articles
                is Resource.Success -> {
                    binding.swipeRefreshLayout.isRefreshing = false
                    adapter.setArticles(resource.data)
                    Log.d(TAG, "observeNewsList: Data ressource --> "+resource.data)
                }
                // On error, show a toast message with the error message
                is Resource.Error -> {
                    binding.swipeRefreshLayout.isRefreshing = false
                    Toast.makeText(requireContext(), resource.message, Toast.LENGTH_SHORT).show()
                }
                // On loading, show the SwipeRefreshLayout loading indicator
                is Resource.Loading -> {
                    binding.swipeRefreshLayout.isRefreshing = true
                }
            }
        }
    }

    private fun fetchNewsList() {
        // Check if the device is connected to the internet
        if (networkUtils.isConnected()) {
            // If connected, call the ViewModel to fetch the news
            viewModel.getNews()
        } else {
            // If not connected, show a Snackbar message
            view?.let { MessageUtils.showSnackbar(it,R.string.error_no_internet) }
            // Hide the SwipeRefreshLayout loading indicator
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun setupCountrySelection() {
        // Set up the country selection buttons
        binding.changeCountry.setOnClickListener {
            // Toggle the selected country between "fr" and "us"
            val selectedCountry = if (binding.imgFr.alpha == 1.0f) {
                binding.imgFr.alpha = 0.3f
                binding.imgUsa.alpha = 1f
                "us"
            } else {
                binding.imgUsa.alpha = 0.3f
                binding.imgFr.alpha = 1f
                "fr"
            }

            // Call the ViewModel to update the selected country and fetch the news
            viewModel.setCountry(selectedCountry)
            fetchNewsList()
        }
    }
}

