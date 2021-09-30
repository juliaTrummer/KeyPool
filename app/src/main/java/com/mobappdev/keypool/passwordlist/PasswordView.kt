package com.mobappdev.keypool.passwordlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobappdev.keypool.R

class PasswordView : AppCompatActivity() {

    private lateinit var pwList : MutableList<KeyItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)
        supportActionBar?.hide()
        fillList()
        createList()
    }

    override fun onBackPressed(){
        super.onBackPressed()
        finishAffinity()
    }

    private fun createList(){
        var rv = findViewById<RecyclerView>(R.id.pwRecycler)
        rv.layoutManager = LinearLayoutManager(this)
        val adapter = PasswordList(pwList, this)
        rv?.adapter = adapter
    }

    private fun fillList(){
        pwList = ArrayList<KeyItem>()

    }
}