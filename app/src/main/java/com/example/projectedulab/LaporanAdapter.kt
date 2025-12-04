package com.example.projectedulab   // ubah sesuai package kamu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LaporanAdapter(private var list: ArrayList<Laporan>) :
    RecyclerView.Adapter<LaporanAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgFile: ImageView = itemView.findViewById(R.id.imgFile)
        val txtJudul: TextView = itemView.findViewById(R.id.txtJudul)
        val txtPages: TextView = itemView.findViewById(R.id.txtPages)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_laporan, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.imgFile.setImageResource(item.image)
        holder.txtJudul.text = item.judul
        holder.txtPages.text = item.pages
    }

    fun updateList(newList: List<Laporan>) {
        list = ArrayList(newList)
        notifyDataSetChanged()
    }
}
