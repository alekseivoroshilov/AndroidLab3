package com.example.lab3_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class About : AppCompatActivity() {

    companion object {
        var text = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about)
        findViewById<TextView>(R.id.textView).text = text
    }
}