package com.mobappdev.keypool.registerlogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.mobappdev.keypool.R
import com.mobappdev.keypool.safepwgeneration.SafePasswordGeneration

class Login : AppCompatActivity() {

    private lateinit var email: TextInputEditText
    private lateinit var emailField : TextInputLayout
    private lateinit var password: TextInputEditText
    private lateinit var passwordField : TextInputLayout
    private lateinit var button: Button
    private lateinit var infoText: TextView
    private lateinit var epa : Authentication
    private lateinit var spg : SafePasswordGeneration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        email = findViewById(R.id.email)
        emailField = findViewById(R.id.emailField)
        password = findViewById(R.id.password)
        passwordField = findViewById(R.id.passwordField)
        button = findViewById(R.id.loginButton)
        infoText = findViewById(R.id.registerInfoText)
        emailField = findViewById(R.id.emailField)
        epa = Authentication()
        epa.init(applicationContext, this)

        button.setOnClickListener() {
            epa.signIn(email.text.toString(), password.text.toString(), emailField, passwordField)
        }

        infoText.setOnClickListener() {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }

}