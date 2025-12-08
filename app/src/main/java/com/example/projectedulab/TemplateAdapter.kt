package com.example.projectedulab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TemplateAdapter(
    private var list: List<Template>,
    private val onItemClick: (Template) -> Unit
) : RecyclerView.Adapter<TemplateAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.imgIcon)
        val txtJudul: TextView = itemView.findViewById(R.id.txtJudul)
        val txtPages: TextView = itemView.findViewById(R.id.txtPages)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_template, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.img.setImageResource(item.imageRes)
        holder.txtJudul.text = item.title
        holder.txtPages.text = item.pages

        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }

    fun updateList(newList: List<Template>) {
        list = newList
        notifyDataSetChanged()
    }
}
