package com.example.lab3_4

import android.content.Intent
import android.content.Intent.*
import android.os.Bundle
import android.widget.Button

class Act1 : Menu() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act1)
        findViewById<Button>(R.id.button).setOnClickListener {
            startActivity(Intent(this, Act2::class.java).setFlags(FLAG_ACTIVITY_REORDER_TO_FRONT))
        }

        findViewById<Button>(R.id.buttonr).setOnClickListener {
            startActivity(Intent(this, Act2::class.java).setFlags(FLAG_ACTIVITY_CLEAR_TOP))
        }
    }

    override fun onResume() {
        About.text = "Activity 1"
        super.onResume()
    }

}