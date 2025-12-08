package com.example.projectedulab

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TemplateFragment : Fragment() {

    private lateinit var adapter: TemplateAdapter
    private lateinit var dataList: ArrayList<Template>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_template, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtHalo = view.findViewById<TextView>(R.id.txtHalo)
        val edtSearch = view.findViewById<EditText>(R.id.edtSearch)
        val rv = view.findViewById<RecyclerView>(R.id.rvLaporan)

        txtHalo.text = "Daftar Template Laporan"

        rv.layoutManager = GridLayoutManager(requireContext(), 2)

        // 1️⃣ LIST DATA TEMPLATE
        // fileName di sini bisa:
        // - URL Google Docs, atau
        // - nama file .docx di assets (kalau kamu pakai assets)
        dataList = arrayListOf(
            Template(
                title = "Template Proposal",
                pages = "Docx",
                imageRes = R.drawable.ic_file,
                fileName = "https://docs.google.com/document/d/1lhP9x"
            ),
            Template(
                title = "Laporan Kerja Praktik",
                pages = "Docx",
                imageRes = R.drawable.ic_file,
                fileName = "https://docs.google.com/document/d/2fA79d"
            ),
            Template(
                title = "Template Makalah",
                pages = "PDF",
                imageRes = R.drawable.ic_file,
                fileName = "https://docs.google.com/document/d/3pU71k"
            ),
            Template(
                title = "Laporan Proyek",
                pages = "Docx",
                imageRes = R.drawable.ic_file,
                fileName = "https://docs.google.com/document/d/4Kd7zV"
            )
        )

        // 2️⃣ SET ADAPTER
        // Saat item di-klik ➜ buka Word / viewer lewat Intent.ACTION_VIEW
        adapter = TemplateAdapter(dataList) { template ->
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(template.fileName))
            startActivity(intent)
        }
        rv.adapter = adapter

        // 3️⃣ FITUR SEARCH
        edtSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val keyword = s.toString().lowercase()

                val filtered = dataList.filter {
                    it.title.lowercase().contains(keyword)
                }

                adapter.updateList(filtered)
            }
        })
    }
}
