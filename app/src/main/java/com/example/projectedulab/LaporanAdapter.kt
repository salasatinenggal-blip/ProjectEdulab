package com.example.projectedulab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LaporanAdapter(private var data: List<Laporan>) :
    RecyclerView.Adapter<LaporanAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.imgCover)
        val judul: TextView = itemView.findViewById(R.id.tvJudul)
        val halaman: TextView = itemView.findViewById(R.id.tvHalaman)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_laporan, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.img.setImageResource(item.cover)
        holder.judul.text = item.judul
        holder.halaman.text = item.halaman
    }

    override fun getItemCount(): Int = data.size

    fun updateList(newList: List<Laporan>) {
        data = newList
        notifyDataSetChanged()
    }
}
