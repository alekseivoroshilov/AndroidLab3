package com.example.lab3_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button

class Act1 : Menu() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act1)
        findViewById<Button>(R.id.button).setOnClickListener {
            startActivity(Intent(this, Act2::class.java))
        }

    }

    override fun onResume() {
        About.text = "About Activity 1"
        super.onResume()
    }
}