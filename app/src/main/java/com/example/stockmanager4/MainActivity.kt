package com.example.stockmanager4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.stockmanager4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val loginpage = findViewById<Button>(R.id.BTstart)

        loginpage.alpha = 0f
        loginpage.translationY = 50F
        loginpage.animate().alpha(1f).translationYBy(-50F).duration = 1500

        loginpage.setOnClickListener {
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
        }

    }
}