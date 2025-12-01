package com.example.projectedulab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Inisialisasi Bottom Nav
        bottomNav = findViewById(R.id.bottom_nav)

        // 2. Tampilkan Fragment awal (HomeFragment) hanya jika ini bukan rekonstruksi Activity
        // Ini MENCEGAH Fragment awal dimuat ulang setiap kali layar diputar
        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }

        // 3. Set Listener untuk Bottom Nav
        // Catatan: setOnNavigationItemSelectedListener dicoret (deprecated)
        // tetapi masih berfungsi dan sesuai dengan struktur kode Anda.
        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> { loadFragment(HomeFragment()); true }
                R.id.nav_template -> { loadFragment(TemplateFragment()); true }
                R.id.nav_history -> { loadFragment(HistoryFragment()); true }
                R.id.nav_profile -> { loadFragment(ProfileFragment()); true }
                else -> false // Jika ID tidak dikenali, jangan tangani event
            }
        }
    }

    // Fungsi untuk mengganti Fragment di container
    private fun loadFragment(fragment: Fragment) {
        // supportFragmentManager adalah FragmentManager bawaan Activity.
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }
}