package com.example.stockmanager4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.stockmanager4.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = Firebase.auth
        val intent = Intent(this, LoginPage::class.java)
        val registeremail = findViewById<EditText>(R.id.ETregisteremail)
        val registerpwd = findViewById<EditText>(R.id.ETregisterpwd1)
        val registerpwdconf = findViewById<EditText>(R.id.ETregisterpwd2)
        val signinbutton = findViewById<Button>(R.id.BTsignup)
        val backtologin = findViewById<Button>(R.id.BTloginpage)

        backtologin.setOnClickListener {
            startActivity(intent)
        }
        signinbutton.setOnClickListener {
            val email = registeremail.text.toString()
            val password = registerpwd.text.toString()
            val password2 = registerpwdconf.text.toString()

            if (password != password2) {
                Toast.makeText(baseContext, "Passwords aren't identical", Toast.LENGTH_SHORT).show()
            } else if (password < 6.toString()) {
                Toast.makeText(baseContext, "Minimum 6 Characters", Toast.LENGTH_SHORT).show()
            } else {
                auth.createUserWithEmailAndPassword(email,
                    password).addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        user!!.sendEmailVerification().addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(baseContext,
                                    "Verification email sent",
                                    Toast.LENGTH_SHORT).show()
                            }
                        }
                        startActivity(intent)
                    } else {
                        Toast.makeText(baseContext, "Sign In Failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}