package com.mobappdev.keypool.PwList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobappdev.keypool.R

class PasswordView : AppCompatActivity() {

    private lateinit var pwList : MutableList<Password>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)
        fillList()
        createList()
    }

    private fun createList(){
        var rv = findViewById<RecyclerView>(R.id.pwRecycler)
        rv.layoutManager = LinearLayoutManager(this)
        val adapter = PasswordList(pwList, this)
        rv?.adapter = adapter
    }

    private fun fillList(){
        pwList = ArrayList<Password>()
        pwList.add(Password("test", 0, "tests"))
        pwList.add(Password("test1", 1, "test11"))
        pwList.add(Password("test", 0, "tests"))
        pwList.add(Password("test1", 1, "test11"))
    }
}