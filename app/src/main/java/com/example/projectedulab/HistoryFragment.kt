package com.example.projectedulab // Pastikan package ini sudah benar

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

        // KOREKSI INI SUDAH BENAR:
        rvHistory = view.findViewById(R.id.rvHistory)
        tvEmptyHistory = view.findViewById(R.id.tvEmptyHistory)

        setupRecyclerView()
        loadHistoryData()

        return view
    }

    private fun setupRecyclerView() {
        // Menggunakan requireContext() lebih aman karena context pasti tersedia di onCreateView
        rvHistory.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun loadHistoryData() {
        // TODO: Ganti dengan logika pengambilan data laporan Anda (dari database/SharedPreferences)
        val dummyData = listOf(
            LaporanHistory("Laporan Praktikum Kimia", "01 Des 2025", "kimia.docx"),
            LaporanHistory("Proposal Skripsi Baru", "25 Nov 2025", "skripsi.docx"),
            LaporanHistory("CV Terbaru", "10 Nov 2025", "cv.docx")
        )

        if (dummyData.isEmpty()) {
            rvHistory.visibility = View.GONE
            tvEmptyHistory.visibility = View.VISIBLE
        } else {
            historyAdapter = HistoryAdapter(dummyData) { laporan ->
                // TODO: Aksi saat item diklik (misalnya, buka laporan menggunakan fungsi seperti di TemplateActivity)
                // openReport(laporan.fileName)
            }
            rvHistory.adapter = historyAdapter
            rvHistory.visibility = View.VISIBLE
            tvEmptyHistory.visibility = View.GONE
        }
    }
}