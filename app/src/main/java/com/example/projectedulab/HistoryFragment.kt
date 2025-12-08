package com.example.projectedulab

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// ⬅ penting: pakai layout fragment_history
class HistoryFragment : Fragment(R.layout.fragment_history) {

    private lateinit var rvHistory: RecyclerView
    private lateinit var tvEmptyHistory: TextView
    private lateinit var historyAdapter: HistoryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ⬅ di screenshot kamu sudah seperti ini, tinggal pastikan import R OK
        rvHistory = view.findViewById(R.id.rvHistory)
        tvEmptyHistory = view.findViewById(R.id.tvEmptyHistory)

        rvHistory.layoutManager = LinearLayoutManager(requireContext())

        loadHistoryData()
    }

    override fun onResume() {
        super.onResume()
        // refresh saat balik dari tab Template
        loadHistoryData()
    }

    private fun loadHistoryData() {
        // AMBIL DATA DUMMY DARI HistoryStore
        val historyData = HistoryStore.historyList

        if (historyData.isEmpty()) {
            rvHistory.visibility = View.GONE
            tvEmptyHistory.visibility = View.VISIBLE
        } else {
            historyAdapter = HistoryAdapter(listHistory = historyData)
            rvHistory.adapter = historyAdapter

            rvHistory.visibility = View.VISIBLE
            tvEmptyHistory.visibility = View.GONE
        }
    }
}
