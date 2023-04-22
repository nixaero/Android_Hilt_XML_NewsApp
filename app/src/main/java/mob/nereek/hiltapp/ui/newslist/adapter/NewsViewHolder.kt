package mob.nereek.hiltapp.ui.newslist.adapter

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import mob.nereek.hiltapp.R
import mob.nereek.hiltapp.data.model.Article
import mob.nereek.hiltapp.databinding.NewsListItemBinding

/**
 * View holder for a news item in the recycler view.
 */
class NewsViewHolder(private val binding: NewsListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    // set original height of layoutParams photo
    private var originalHeight = binding.photo.layoutParams.height

    /**
     * Binds the article data to the view.
     */
    fun onBind(article: Article) {
        // Set the visibility of details to GONE to hide them initially
        binding.details.visibility = View.GONE

        // Set up click listener for the card view
        binding.cardView.setOnClickListener {

            // Check if details are currently hidden
            if (binding.details.visibility == View.GONE ) {
                // Increase the height of the photo view
                binding.photo.layoutParams.height = originalHeight + 200
                // Set the visibility of details to VISIBLE to show them
                binding.details.visibility = View.VISIBLE
            } else {
                // Decrease the height of the photo view
                binding.photo.layoutParams.height = originalHeight
                // Set the visibility of details to GONE to hide them
                binding.details.visibility = View.GONE
            }
        }

        // Set up click listener for the open browser button
        binding.openBrowser.setOnClickListener {
            openInBrowser(article.url.toString())
        }

        // Load article data into views
        binding.photo.load(article.urlToImage){
            error(R.drawable.ic_launcher_background)
        }
        binding.author.text = article.author
        binding.date.text = article.publishedAt
        binding.title.text = article.title
        binding.source.text = article.source?.name ?: "[Source Name Not Available]"
        binding.description.text = article.description?:(" [Description Not Available] ")
    }

    // Function to open article in browser
    fun openInBrowser(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        binding.root.context.startActivity(browserIntent)
    }
}