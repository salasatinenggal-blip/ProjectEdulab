package com.example.projectedulab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryFragment : Fragment() {

    private lateinit var rvHistory: RecyclerView
    private lateinit var tvEmptyHistory: TextView
    private lateinit var historyAdapter: HistoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_history, container, false)

        rvHistory = view.findViewById(R.id.rvHistory)
        tvEmptyHistory = view.findViewById(R.id.tvEmptyHistory)

        rvHistory.layoutManager = LinearLayoutManager(requireContext())

        loadHistoryData()
        return view
    }

    private fun loadHistoryData() {

        val dummyData = listOf(
            LaporanHistory(
                "Laporan Tugas Pemrograman Mobile",
                "08 Des 2025",
                "tugas_mobile.docx",
                "https://docs.google.com/document/d/12rSGrD7DuidwAMY0Mzae3TbWIeDcrF_84HIK79ZMRB8/edit?usp=sharing"
            ),
            LaporanHistory(
                "Laporan Tugas Basis Data",
                "05 Des 2025",
                "tugas_basisdata.pdf",
                "https://docs.google.com/document/d/19oOJA4Fo_sWKHCVOzYHyXNCPcTdgSYD4xR_9FX_q5Po/edit?usp=sharing"
            ),
            LaporanHistory(
                "Laporan Praktikum IoT Sensor Suhu",
                "03 Des 2025",
                "tugas_iot_suhu.docx",
                "https://docs.google.com/document/d/19x7ed4NcaYS-TiL91ieUTHQfxHhusgEAjvzoE0jiERM/edit?usp=sharing"
            )
            // Tambahkan item lain dengan format sama
        )

        if (dummyData.isEmpty()) {
            rvHistory.visibility = View.GONE
            tvEmptyHistory.visibility = View.VISIBLE
        } else {
            historyAdapter = HistoryAdapter(dummyData)
            rvHistory.adapter = historyAdapter

            rvHistory.visibility = View.VISIBLE
            tvEmptyHistory.visibility = View.GONE
        }
    }
}
