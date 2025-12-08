package com.example.projectedulab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(
    private val newsList: List<NewsItem>
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivNewsImage: ImageView = itemView.findViewById(R.id.ivNewsImage)
        val tvNewsTitle: TextView = itemView.findViewById(R.id.tvNewsTitle)
        val tvNewsSummary: TextView = itemView.findViewById(R.id.tvNewsSummary)

        fun bind(news: NewsItem) {
            tvNewsTitle.text = news.title
            tvNewsSummary.text = news.summary
            ivNewsImage.setImageResource(news.imageUrl)

            // Tidak perlu setOnClickListener karena Anda tidak ingin item bisa diklik
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_berita, // Pastikan ini adalah nama file XML item Anda
            parent,
            false
        )
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}