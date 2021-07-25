package com.mobappdev.keypool

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.mobappdev.keypool.RegisterLogin.Login


class Register : AppCompatActivity() {

    private lateinit var email : TextInputEditText
    private lateinit var username : TextInputEditText
    private lateinit var password : TextInputEditText
    private lateinit var button : Button
    private lateinit var infoText : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        email = findViewById(R.id.email)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        button = findViewById(R.id.registerButton)
        infoText = findViewById(R.id.loginInfoText)

        button.setOnClickListener(){

        }

        infoText.setOnClickListener(){
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }

    private fun register(){
        //validate
        //register
        //toast
    }

}