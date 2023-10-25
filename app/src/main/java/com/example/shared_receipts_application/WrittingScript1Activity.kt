package com.example.shared_receipts_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WrittingScript1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writting_script1)

        val writting2Button = findViewById<Button>(R.id.writting1_nextbutton)
        writting2Button.setOnClickListener {
            val myIntent = Intent(this, WrittingScript2Activity::class.java)
            startActivity(myIntent)
        }

    }
}