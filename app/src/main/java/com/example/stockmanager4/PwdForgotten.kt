package com.example.stockmanager4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class PwdForgotten : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pwd_forgotten)

        auth = Firebase.auth
        val emailforgot = findViewById<EditText>(R.id.ETforgotmail)
        val btpwdforgot = findViewById<Button>(R.id.BTresetpwd)
        val returnbacktologin = findViewById<Button>(R.id.BTreturnlogin)
        val intent = Intent(this,LoginPage::class.java)

        returnbacktologin.setOnClickListener {
            startActivity(intent)
        }

        btpwdforgot.setOnClickListener {
                val email = emailforgot.text.toString()
                Firebase.auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(baseContext,"An email to reset your password has been sent to you", Toast.LENGTH_LONG).show()
                            Firebase.auth.signOut()
                            startActivity(intent)
                        }else{
                            Toast.makeText(baseContext, "Your email address does not exist", Toast.LENGTH_SHORT).show()
                        }
                    }
        }
    }
}