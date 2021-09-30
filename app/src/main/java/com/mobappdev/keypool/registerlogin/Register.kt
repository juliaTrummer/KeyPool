package com.mobappdev.keypool.registerlogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.mobappdev.keypool.R
import com.mobappdev.keypool.registerlogin.Login

class Register : AppCompatActivity() {

    val REGEX : Regex = Regex("(^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%!\\-_?&])(?=\\S+\$).{8,})")

    private lateinit var email : TextInputEditText
    private lateinit var emailField : TextInputLayout
    private lateinit var username : TextInputEditText
    private lateinit var password : TextInputEditText
    private lateinit var passwordField : TextInputLayout
    private lateinit var button : Button
    private lateinit var infoText : TextView
    private lateinit var emailPasswordActivity: Authentication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar?.hide()

        emailPasswordActivity = Authentication()
        emailPasswordActivity.init(applicationContext, this)

        email = findViewById(R.id.email)
        emailField = findViewById(R.id.emailField)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        passwordField = findViewById(R.id.passwordField)
        button = findViewById(R.id.registerButton)
        infoText = findViewById(R.id.loginInfoText)

        button.setOnClickListener(){
            register()
        }

        infoText.setOnClickListener(){
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }

    private fun register(){
        var validEmail : Boolean = validateEmail(email.text.toString())
        var strongPW : Boolean = validatePassword(password.text.toString())
        if(strongPW && validEmail){
            passwordField.error = null
            emailField.error = null
            emailPasswordActivity.createAccount(email.text.toString(), password.text.toString())
            Toast.makeText(this, "Register is a success.", Toast.LENGTH_SHORT).show()
        } else if(strongPW){
            passwordField.error = null
        } else if(validEmail){
            emailField.error = null
        }
    }

    private fun validateUserName(){


    }

    //create better Messages
    fun validatePassword(input: CharSequence): Boolean {
        if(password.text!=null){
            if(!REGEX.containsMatchIn(input)){
                passwordField.error = "Password must contain numbers, symbols and letters!"
                return false
            }
        }
        return true
    }

    fun validateEmail(input: CharSequence): Boolean {
        if(email.text!=null){
            if(!(input.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(input).matches())){
                emailField.error = "Please enter a valid Email!"
                return false
            }
        }
        return true
    }

}