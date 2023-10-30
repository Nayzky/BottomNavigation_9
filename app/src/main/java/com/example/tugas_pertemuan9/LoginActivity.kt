//package com.example.tugas_pertemuan9
//
//import android.content.Intent
//import android.content.SharedPreferences
//import android.os.Bundle
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import com.example.tugas_pertemuan9.databinding.ActivityLoginBinding
//
//class LoginActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityLoginBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityLoginBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.edtUsername.hint = "Masukkan username"
//        binding.edtPassword.hint = "Masukkan password"
//
//        binding.btnLogin.setOnClickListener {
//            val username = binding.edtUsername.text.toString()
//            val password = binding.edtPassword.text.toString()
//
//            if (checkLogin(username, password)) {
//                // Simpan status login di SharedPreferences
//                saveLoginStatus(true)
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
//                finish()
//            } else {
//                Toast.makeText(
//                    this@LoginActivity,
//                    "Username atau Password Salah",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        }
//    }
//
//    private fun checkLogin(username: String, password: String): Boolean {
//        val staticUsername = "Innaiya azkiya H"
//        val staticPassword = "496809"
//        return username == staticUsername && password == staticPassword
//    }
//
//    private fun saveLoginStatus(isLoggedIn: Boolean) {
//        val sharedPreferences: SharedPreferences = getSharedPreferences("login_data", MODE_PRIVATE)
//        val editor: SharedPreferences.Editor = sharedPreferences.edit()
//        editor.putBoolean("is_logged_in", isLoggedIn)
//        editor.apply()
//    }
//}
