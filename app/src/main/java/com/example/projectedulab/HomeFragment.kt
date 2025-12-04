package com.example.yourappname   // ganti sesuai package kamu

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

class HomeFragment : Fragment() {

    private lateinit var adapter: LaporanAdapter
    private lateinit var dataList: ArrayList<Laporan>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtHalo = view.findViewById<TextView>(R.id.txtHalo)
        val edtSearch = view.findViewById<EditText>(R.id.edtSearch)
        val rv = view.findViewById<RecyclerView>(R.id.rvLaporan)

        txtHalo.text = "Halo, User!"

        rv.layoutManager = GridLayoutManager(requireContext(), 2)

        dataList = arrayListOf(
            Laporan("Laporan Basis Data", "18 Pages", R.drawable.ic_file),
            Laporan("Laporan Jaringan", "28 Pages", R.drawable.ic_file),
            Laporan("Laporan Manajemen", "30 Pages", R.drawable.ic_file),
            Laporan("Laporan Matematika", "14 Pages", R.drawable.ic_file)
        )

        adapter = LaporanAdapter(dataList)
        rv.adapter = adapter

        edtSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val keyword = s.toString().lowercase()
                val filteredList = dataList.filter {
                    it.judul.lowercase().contains(keyword)
                }
                adapter.updateList(filteredList)
            }
        })
    }
}
