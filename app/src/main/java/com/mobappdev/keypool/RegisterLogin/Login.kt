package com.mobappdev.keypool.RegisterLogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.mobappdev.keypool.PwList.PasswordView
import com.mobappdev.keypool.R
import com.mobappdev.keypool.Register

class Login : AppCompatActivity() {

    private lateinit var email: TextInputEditText
    private lateinit var emailField : TextInputLayout
    private lateinit var password: TextInputEditText
    private lateinit var passwordField : TextInputLayout
    private lateinit var button: Button
    private lateinit var infoText: TextView
    private lateinit var epa : EmailPasswordActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.email)
        emailField = findViewById(R.id.emailField)
        password = findViewById(R.id.password)
        passwordField = findViewById(R.id.passwordField)
        button = findViewById(R.id.loginButton)
        infoText = findViewById(R.id.registerInfoText)
        emailField = findViewById(R.id.emailField)
        epa = EmailPasswordActivity()
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