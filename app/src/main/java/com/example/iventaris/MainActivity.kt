package com.example.iventaris

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.iventaris.DashboardFragment
import com.example.iventaris.BarangFragment
import com.example.iventaris.PeminjamanFragment
import com.example.iventaris.UserFragment
import com.example.iventaris.ProfilFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_dashboard -> loadFragment(DashboardFragment())
                R.id.nav_barang -> loadFragment(BarangFragment())
                R.id.nav_peminjaman -> loadFragment(PeminjamanFragment())
                R.id.nav_user -> loadFragment(UserFragment())
                R.id.nav_profil -> loadFragment(ProfilFragment())
            }
            true
        }

        bottomNav.selectedItemId = R.id.nav_dashboard
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
