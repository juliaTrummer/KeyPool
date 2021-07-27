package com.mobappdev.keypool.RegisterLogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.mobappdev.keypool.PwList.PasswordView
import com.mobappdev.keypool.R
import com.mobappdev.keypool.Register

class Login : AppCompatActivity() {

    private lateinit var email: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var button: Button
    private lateinit var infoText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        button = findViewById(R.id.loginButton)
        infoText = findViewById(R.id.registerInfoText)

        button.setOnClickListener() {
            val intent = Intent(this, PasswordView::class.java)
            startActivity(intent)
        }

        infoText.setOnClickListener() {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }
}