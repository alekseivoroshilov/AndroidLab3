package com.example.lab3_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button


class Act2 : Menu() {
    val ACT1_OR_ACT3 = 0 /*Для возврата в Activity1 понадобится помощь со стороны Activity2.
    Для того, чтобы известить Activity2 о необходимости завершиться, используем код возврата*/
    val TO_ACT1 = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act2)
        findViewById<Button>(R.id.button2).setOnClickListener {
            this.finish()
        }
        findViewById<Button>(R.id.button3).setOnClickListener {
            startActivityForResult(Intent(this, Act3::class.java), ACT1_OR_ACT3)
        }
    }
    //нужно узнать что привело к завершению Activity3
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == TO_ACT1) this.finish()
    }

    override fun onResume() {
        About.text = "Activity 2"
        super.onResume()
    }
}