package com.mobappdev.keypool.addView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.mobappdev.keypool.R

class FormView : AppCompatActivity() {

    private lateinit var websiteName : TextInputEditText
    private lateinit var username : TextInputEditText
    private lateinit var password : TextInputEditText
    private lateinit var description : TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formview)
        supportActionBar?.hide()

        websiteName = findViewById(R.id.website)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        description = findViewById(R.id.description)

    }
}