package com.example.stockmanager4

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.stockmanager4.databinding.ActivityLoginPageBinding
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
        auth.currentUser
        val resetpwd = findViewById<Button>(R.id.BTforgotpwd)
        val loginmail = findViewById<EditText>(R.id.BTemaillogin)
        val loginpwd = findViewById<EditText>(R.id.BTpwdlogin)
        val loginbutton = findViewById<Button>(R.id.BTlogin)
        val register = findViewById<Button>(R.id.BTregister)

        loginbutton.alpha = 0f
        loginbutton.translationY = 50F
        loginbutton.animate().alpha(1f).translationYBy(-50F).duration = 1500

        register.alpha = 0f
        register.translationY = 50F
        register.animate().alpha(1f).translationYBy(-50F).duration = 1500

        resetpwd.setOnClickListener {
            val intent = Intent(this, PwdForgotten::class.java)
            startActivity(intent)
        }

        loginbutton.setOnClickListener {
            val email = loginmail.text.toString()
            val password = loginpwd.text.toString()
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(baseContext,"Login Succeeded", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, OrderingSheet::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()

                    }
                }
        }


        register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
    @SuppressLint("SetTextI18n")
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