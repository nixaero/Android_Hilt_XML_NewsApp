package mob.nereek.hiltapp.ui.newslist.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mob.nereek.hiltapp.data.model.Article
import mob.nereek.hiltapp.databinding.NewsListItemBinding
import javax.inject.Inject

class NewsListAdapter @Inject constructor(): RecyclerView.Adapter<NewsViewHolder>() {
    // Mutable list to hold articles
    private var articles: MutableList<Article> = mutableListOf()

    // Inflate layout for item view and create view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = NewsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(view)
    }

    // Bind article data to the view holder at the given position in the articles list
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        // Call the onBind function of the view holder to bind the article data to its views
        holder.onBind(articles[position])
    }

    // Return the number of articles in the list
    override fun getItemCount(): Int {
        return articles.size
    }

    // Function to set new list of articles and notify adapter
    fun setArticles(articles: List<Article>) {
        // Clear current list and add new articles
        this.articles.clear()
        this.articles.addAll(articles)
        // Notify adapter that data has changed
        notifyDataSetChanged()
    }
}