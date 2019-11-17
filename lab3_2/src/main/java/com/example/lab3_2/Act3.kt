package com.example.lab3_2

import android.os.Bundle
import android.widget.Button

class Act3 : Menu() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val TO_ACT1 = 1
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act3)
        findViewById<Button>(R.id.button4).setOnClickListener {
            setResult(TO_ACT1)
            this.finish()
        }
        findViewById<Button>(R.id.button5).setOnClickListener { this.finish() }
    }

    override fun onResume() {
        About.text = "Activity 3"
        super.onResume()
    }
}