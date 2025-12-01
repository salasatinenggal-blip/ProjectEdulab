package com.example.projectedulab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout XML untuk fragment ini
        // Ganti R.layout.fragment_home dengan nama file XML layout fragment Anda
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    // Tempatkan logika Fragment (misalnya: inisialisasi View, listener) di sini
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Contoh: Mengakses View dari fragment_home.xml
        // val myTextView = view.findViewById<TextView>(R.id.my_text_view)
        // myTextView.text = "Selamat Datang!"
    }
}