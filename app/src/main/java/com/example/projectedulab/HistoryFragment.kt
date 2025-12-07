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

        setupRecyclerView()
        loadHistoryData()

        return view
    }

    private fun setupRecyclerView() {
        rvHistory.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun loadHistoryData() {
        val dummyData = listOf(
            LaporanHistory("Laporan Tugas Pemrograman Mobile", "08 Des 2025", "tugas_mobile.docx"),
            LaporanHistory("Laporan Tugas Basis Data", "05 Des 2025", "tugas_basisdata.pdf"),
            LaporanHistory("Laporan Tugas IoT Sensor Suhu", "03 Des 2025", "tugas_iot_suhu.docx"),
            LaporanHistory("Laporan Tugas Jaringan Komputer", "01 Des 2025", "tugas_jarkom.pdf"),
            LaporanHistory("Laporan Tugas Sistem Cerdas", "28 Nov 2025", "tugas_sisop.docx"),
            LaporanHistory("Laporan Tugas Praktikum IoT Monitoring", "22 Nov 2025", "tugas_iot_monitoring.pdf"),
            LaporanHistory("Laporan Tugas Sistem Informasi", "15 Nov 2025", "tugas_sisteminformasi.docx"),
            LaporanHistory("Laporan Tugas Fiber optic", "13 Nov 2025", "tugas_diskrit.pdf"),
            LaporanHistory("Laporan Tugas Pengantar Data Science", "08 Nov 2025", "tugas_datascience.pdf"),
            LaporanHistory("Laporan Tugas UI/UX Research", "06 Nov 2025", "tugas_uxresearch.docx"),
            LaporanHistory("Resume Pertemuan Pemrograman Mobile", "30 Nov 2025", "resume_mobile.docx"),
            LaporanHistory("Resume Materi Basis Data", "27 Nov 2025", "resume_basisdata.pdf"),
            LaporanHistory("Resume Praktikum IoT", "25 Nov 2025", "resume_iot.docx"),
            LaporanHistory("Resume Jaringan Komputer", "23 Nov 2025", "resume_jarkom.pdf"),
            LaporanHistory("Resume Sistem Operasi", "19 Nov 2025", "resume_sisop.docx"),
            LaporanHistory("Resume Pertemuan Struktur Data", "16 Nov 2025", "resume_strukturdata.pdf"),
            LaporanHistory("Resume AI - Machine Learning", "14 Nov 2025", "resume_ai.docx"),
            LaporanHistory("Resume Analisis Algoritma", "12 Nov 2025", "resume_algoritma.pdf"),
            LaporanHistory("Resume Teknologi Web", "09 Nov 2025", "resume_web.docx"),
            LaporanHistory("Resume Sistem Cerdas", "07 Nov 2025", "resume_sisteminformasi.pdf"),
            LaporanHistory("Resume Fiber Optic", "04 Nov 2025", "resume_diskrit.docx"),
            LaporanHistory("Resume Cloud Computing", "02 Nov 2025", "resume_cloud.pdf"),
            LaporanHistory("Resume Tata Kelola Teknologi Informasi", "30 Okt 2025", "resume_datascience.docx"),
            LaporanHistory("Resume UI/UX Research", "28 Okt 2025", "resume_uxresearch.pdf"),
            LaporanHistory("Resume Keamanan Sistem Informasi", "26 Okt 2025", "resume_keamanan.docx")
        )

        if (dummyData.isEmpty()) {
            rvHistory.visibility = View.GONE
            tvEmptyHistory.visibility = View.VISIBLE
        } else {
            historyAdapter = HistoryAdapter(dummyData) { laporan ->
                // TODO: Aksi ketika item diklik
            }

            rvHistory.adapter = historyAdapter
            rvHistory.visibility = View.VISIBLE
            tvEmptyHistory.visibility = View.GONE
        }
    }
}
