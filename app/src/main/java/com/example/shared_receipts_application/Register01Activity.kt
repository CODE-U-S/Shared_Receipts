package com.example.shared_receipts_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageButton

class Register01Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register01)

        val checkboxAll = findViewById<CheckBox>(R.id.checkbox_all)
        val checkbox01 = findViewById<CheckBox>(R.id.checkbox_01)
        val checkbox02 = findViewById<CheckBox>(R.id.checkbox_02)
        val checkbox03 = findViewById<CheckBox>(R.id.checkbox_03)

        checkboxAll.setOnClickListener {
            val isChecked = checkboxAll.isChecked
            checkbox01.isChecked = isChecked
            checkbox02.isChecked = isChecked
            checkbox03.isChecked = isChecked
        }

        val loginButton = findViewById<ImageButton>(R.id.register01_loginbutton)
        loginButton.setOnClickListener {
            if (checkbox01.isChecked && checkbox02.isChecked) {
                // Register02Activity로 화면 전환
                val intent = Intent(this, Register02Activity::class.java)
                startActivity(intent)
            } else {
                // checkbox_01와 checkbox_02 중 하나 이상이 체크되지 않았을 때 아무 동작 없음
            }
        }

        // checkbox_01, checkbox_02, checkbox_03 클릭 이벤트 처리
        checkbox01.setOnClickListener {
            if (checkboxAll.isChecked) {
                checkboxAll.isChecked = false
            }
        }

        checkbox02.setOnClickListener {
            if (checkboxAll.isChecked) {
                checkboxAll.isChecked = false
            }
        }

        checkbox03.setOnClickListener {
            if (checkboxAll.isChecked) {
                checkboxAll.isChecked = false
            }
        }
    }
}
