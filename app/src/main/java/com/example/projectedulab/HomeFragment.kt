package com.example.projectedulab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectedulab.R

class HomeFragment : Fragment() {

    private lateinit var rvBerita: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Pastikan ID di XML adalah rvBerita
        rvBerita = view.findViewById(R.id.rvBerita)

        setupRecyclerView()

        return view
    }

    private fun setupRecyclerView() {
        // Buat data contoh (sesuai dengan screenshot Anda)
        val newsData = listOf(
            NewsItem(
                title = "Recap PNM CUP 2025",
                summary = "PNM CUP terutama futsal banyak diminati mahasiswa...",
                imageUrl = R.drawable.banner_kampus // Ganti dengan drawable ID yang benar
            ),
            NewsItem(
                title = "Wisuda Mahasiswa Politeknik Negeri Madiun",
                summary = "Wisuda Politeknik Negeri Madiun akan diselenggarakan...",
                imageUrl = R.drawable.banner_event // Ganti dengan drawable ID yang benar
            ),
            NewsItem(
                title = "Beasiswa Prestasi 2025 Dibuka!",
                summary = "Beasiswa prestasi kembali dibuka...",
                imageUrl = R.drawable.banner_3 // Ganti dengan drawable ID yang benar
            )
        )

        val newsAdapter = NewsAdapter(newsData)
        rvBerita.layoutManager = LinearLayoutManager(requireContext())
        rvBerita.adapter = newsAdapter
    }
}