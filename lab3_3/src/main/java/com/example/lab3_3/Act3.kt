package com.example.lab3_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button

class Act3 : Menu() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act3)
        findViewById<Button>(R.id.button4).setOnClickListener {
            startActivity(Intent(this, Act1::class.java).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT))
        }
        findViewById<Button>(R.id.button5).setOnClickListener {
            startActivity(Intent(this, Act2::class.java).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT))
        }
    }

    override fun onResume() {
        About.text = "Activity 3"
        super.onResume()
    }
}