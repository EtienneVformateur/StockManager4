package com.example.stockmanager4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.stockmanager4.databinding.ActivityLoginPageBinding
import com.example.stockmanager4.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginPage : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = Firebase.auth

        val register = findViewById<Button>(R.id.BTregister)
        register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        val status = findViewById<TextView>(R.id.TVstatusconnexion)
        if(currentUser != null){
            status.text = "ONLINE"
        }else {
            status.text = "OFFLINE"
        }
    }
}