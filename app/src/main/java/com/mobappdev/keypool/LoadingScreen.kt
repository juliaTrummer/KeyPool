package com.mobappdev.keypool

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobappdev.keypool.passwordlist.PasswordView
import com.mobappdev.keypool.registerlogin.Authentication
import com.mobappdev.keypool.registerlogin.Register

class LoadingScreen : AppCompatActivity() {

    private lateinit var auth : Authentication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loadingscreen)

        supportActionBar?.hide()

        auth = Authentication()
        auth.init(applicationContext, this)

        if(auth.isLoggedIn()){
            val intent = Intent(this, PasswordView::class.java)
            startActivity(intent)
        }else {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

    }
}