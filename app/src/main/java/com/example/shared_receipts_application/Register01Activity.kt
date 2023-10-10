package com.example.shared_receipts_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox

class Register01Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register01)

        val checkboxAll = findViewById<CheckBox>(R.id.checkbox_all)
        val checkbox01 = findViewById<CheckBox>(R.id.checkbox_01)
        val checkbox02 = findViewById<CheckBox>(R.id.checkbox_02)
        val checkbox03 = findViewById<CheckBox>(R.id.checkbox_03)

        checkboxAll.setOnClickListener {
            // Checkbox All이 클릭되었을 때 수행할 동작
            val isChecked = checkboxAll.isChecked
            checkbox01.isChecked = isChecked
            checkbox02.isChecked = isChecked
            checkbox03.isChecked = isChecked
        }

        checkbox01.setOnClickListener {
            // Checkbox 01이 클릭되었을 때 수행할 동작
        }

        checkbox02.setOnClickListener {
            // Checkbox 02가 클릭되었을 때 수행할 동작
        }

        checkbox03.setOnClickListener {
            // Checkbox 03이 클릭되었을 때 수행할 동작
        }
    }
}
