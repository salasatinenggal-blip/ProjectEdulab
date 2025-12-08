package com.example.projectedulab

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TemplateAdapter(
    private var list: List<Laporan>
) : RecyclerView.Adapter<TemplateAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageView>(R.id.imgIcon)
        val judul = itemView.findViewById<TextView>(R.id.txtJudul)
        val tipe = itemView.findViewById<TextView>(R.id.txtTipe)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_template, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.img.setImageResource(item.icon)
        holder.judul.text = item.judul
        holder.tipe.text = item.tipe

        // Klik membuka Google Docs
        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.url))
            it.context.startActivity(intent)
        }
    }

    fun updateList(newList: List<Laporan>) {
        list = newList
        notifyDataSetChanged()
    }
}
