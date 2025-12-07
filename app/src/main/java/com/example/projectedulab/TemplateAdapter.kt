package com.example.projectedulab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TemplateAdapter(
    private var listTemplate: List<Template>,   // <-- UBAH: sekarang var agar bisa di-update
    private val onClickItemTemplate: (Template) -> Unit
) : RecyclerView.Adapter<TemplateAdapter.TemplateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemplateViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_template, parent, false)
        return TemplateViewHolder(layout)
    }

    override fun onBindViewHolder(holder: TemplateViewHolder, position: Int) {
        val template = listTemplate[position]

        holder.row.setOnClickListener {
            onClickItemTemplate(template)
        }

        holder.imgCover.setImageResource(template.imageRes)
        holder.txtTitle.text = template.title
        holder.txtPages.text = template.pages
    }

    override fun getItemCount(): Int = listTemplate.size

    // 🔥 Tambahan penting untuk search agar tidak crash
    fun updateList(newList: List<Template>) {
        listTemplate = newList
        notifyDataSetChanged()
    }

    class TemplateViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
        val imgCover: ImageView = row.findViewById(R.id.imgCover)
        val txtTitle: TextView = row.findViewById(R.id.txtTitle)
        val txtPages: TextView = row.findViewById(R.id.txtPages)
    }
}
