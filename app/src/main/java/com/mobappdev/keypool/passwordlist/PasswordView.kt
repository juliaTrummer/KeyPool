package com.mobappdev.keypool.passwordlist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mobappdev.keypool.R
import com.mobappdev.keypool.addView.FormView
import com.mobappdev.keypool.safepwgeneration.SafePasswordGeneration
import com.mobappdev.keypool.safepwgeneration.db.Database

class PasswordView : AppCompatActivity() {


    private lateinit var pwList : MutableList<KeyItem>
    private lateinit var spg : SafePasswordGeneration
    private lateinit var db : Database
    private lateinit var floatButton : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)
        supportActionBar?.hide()

        db = Database()
        db.init(applicationContext)

        fillList()
        createList()

        spg = SafePasswordGeneration()
        spg.close("Password")

        floatButton = findViewById(R.id.floaty)
        floatButton.setOnClickListener {
            val intent = Intent(this, FormView::class.java)
            startActivity(intent)
        }
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
        db.collectData()
        db.safeData("keyitem",
            KeyItem("Test", "Test",
                Password("string", 1, "string")
            ))
    }
}