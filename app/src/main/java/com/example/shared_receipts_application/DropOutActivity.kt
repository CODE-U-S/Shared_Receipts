package com.example.shared_receipts_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.Toast

class DropOutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drop_out)

        val checkBox = findViewById<CheckBox>(R.id.check_drop_out) // CheckBox로 변경

        checkBox.setOnClickListener {
            if (checkBox.isChecked) {
                val intent = Intent(this, LoginActivity::class.java) // CheckBox의 isChecked 속성 사용
                startActivity(intent)
            } else {
                Toast.makeText(this, "동의하십시오.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}