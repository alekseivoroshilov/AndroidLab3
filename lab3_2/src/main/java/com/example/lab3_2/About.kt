package com.example.lab3_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import java.lang.StringBuilder

class About : AppCompatActivity() {

    companion object {
        var text = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about)
        val sb = StringBuilder()
        findViewById<TextView>(R.id.textView).text = text
    }
}