package com.example.lab3_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button

class Act2 : Menu() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act2)
        findViewById<Button>(R.id.button2).setOnClickListener {
            startActivity(Intent(this, Act1::class.java).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT))
        }
        findViewById<Button>(R.id.button3).setOnClickListener {
            startActivity(Intent(this, Act3::class.java).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT))
        }
    }

    override fun onResume() {
        About.text = "Activity 2"
        super.onResume()
    }
}