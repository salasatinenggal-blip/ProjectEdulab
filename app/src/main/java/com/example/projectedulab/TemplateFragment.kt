package com.example.projectedulab

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

    private lateinit var adapter: LaporanAdapter
    private lateinit var dataList: ArrayList<Laporan>

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

        // DATA TEMPLATE
        dataList = arrayListOf(
            Laporan("Template Proposal", "Docx", R.drawable.ic_file),
            Laporan("Laporan Kerja Praktik", "Docx", R.drawable.ic_file),
            Laporan("Template Makalah", "PDF", R.drawable.ic_file),
            Laporan("Laporan Proyek", "Docx", R.drawable.ic_file)
        )

        adapter = LaporanAdapter(dataList)
        rv.adapter = adapter

        // FITUR SEARCH
        edtSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val keyword = s?.toString()?.lowercase() ?: ""

                val filtered = dataList.filter { laporan ->
                    laporan.judul.lowercase().contains(keyword)
                }

                adapter.updateList(filtered)
            }
        })
    }
}
