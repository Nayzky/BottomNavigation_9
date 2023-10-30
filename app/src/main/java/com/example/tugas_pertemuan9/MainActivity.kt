package com.example.tugas_pertemuan9

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tugas_pertemuan9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        if (!isUserLoggedIn()) {
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//            finish()
//            return
//        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(Home())

        binding.bottomNavBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> replaceFragment(Home())
                R.id.nav_Detail -> replaceFragment(Detail())
                R.id.nav_Order -> replaceFragment(Order())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

    fun setSelectedNavItem(itemId: Int) {
        binding.bottomNavBar.selectedItemId = itemId
    }

    private fun isUserLoggedIn(): Boolean {
        val sharedPreferences: SharedPreferences = getSharedPreferences("login_data", MODE_PRIVATE)
        return sharedPreferences.getBoolean("is_logged_in", false)
    }
}