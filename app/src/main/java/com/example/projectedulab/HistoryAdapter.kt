package com.example.projectedulab // Ganti dengan nama package Anda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Asumsi Anda sudah mendefinisikan LaporanHistory di HistoryFragment.kt
// data class LaporanHistory(val title: String, val date: String, val fileName: String)

class HistoryAdapter(
    private val historyList: List<LaporanHistory>,
    private val clickListener: (LaporanHistory) -> Unit // Lambda untuk menangani klik
) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    // --- 1. ViewHolder (Menghubungkan View) ---
    // ViewHolder menyimpan referensi ke semua View yang ada di item_history.xml
    inner class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvReportTitle: TextView = itemView.findViewById(R.id.tvReportTitle)
        val tvReportDate: TextView = itemView.findViewById(R.id.tvReportDate)
        val ivOpen: ImageView = itemView.findViewById(R.id.ivOpen) // Tombol Aksi

        fun bind(laporan: LaporanHistory, clickListener: (LaporanHistory) -> Unit) {
            tvReportTitle.text = laporan.title
            tvReportDate.text = "Disimpan: ${laporan.date}"

            // Menetapkan click listener pada item atau tombol aksi
            itemView.setOnClickListener {
                clickListener(laporan)
            }
            // Anda juga bisa menetapkan listener khusus pada tombol Buka (ivOpen)
            ivOpen.setOnClickListener {
                clickListener(laporan)
            }
        }
    }

    // --- 2. onCreateViewHolder (Membuat View Baru) ---
    // Dipanggil ketika RecyclerView membutuhkan ViewHolder baru
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_history,
            parent,
            false
        )
        return HistoryViewHolder(view)
    }

    // --- 3. onBindViewHolder (Mengisi Data ke View) ---
    // Dipanggil untuk menampilkan data pada posisi tertentu
    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val laporan = historyList[position]
        holder.bind(laporan, clickListener)
    }

    // --- 4. getItemCount (Jumlah Item) ---
    // Mengembalikan total item dalam daftar
    override fun getItemCount(): Int {
        return historyList.size
    }
}