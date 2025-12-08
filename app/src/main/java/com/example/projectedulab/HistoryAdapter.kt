package com.example.projectedulab

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter(
    private val listHistory: List<LaporanHistory>
) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvJudul: TextView = itemView.findViewById(R.id.tvReportTitle)
        val tvTanggal: TextView = itemView.findViewById(R.id.tvReportDate)
        val btnOpen: ImageView = itemView.findViewById(R.id.ivOpen)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_history, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listHistory.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listHistory[position]

        holder.tvJudul.text = item.judul
        holder.tvTanggal.text = "Disimpan: ${item.tanggal}"

        // BUKA GOOGLE DOCS SAAT DIKLIK
        val openDoc = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.url))
            holder.itemView.context.startActivity(intent)
        }

        // Klik card
        holder.itemView.setOnClickListener { openDoc() }

        // Klik icon open
        holder.btnOpen.setOnClickListener { openDoc() }
    }
}
