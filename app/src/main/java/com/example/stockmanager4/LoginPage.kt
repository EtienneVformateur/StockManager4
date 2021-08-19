package com.example.stockmanager4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.stockmanager4.databinding.ActivityLoginPageBinding
import com.example.stockmanager4.databinding.ActivityMainBinding

class LoginPage : AppCompatActivity() {

    private lateinit var binding: ActivityLoginPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val register = findViewById<Button>(R.id.BTregister)
        register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}