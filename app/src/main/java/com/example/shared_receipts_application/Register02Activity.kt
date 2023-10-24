package com.example.shared_receipts_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.content.Intent
import android.widget.ImageButton

class Register02Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register02)

        val passwordText = findViewById<EditText>(R.id.re02_password_text)
        val verifyPasswordText = findViewById<EditText>(R.id.re02_verify_password_text)
        val passwordMismatchTextView = findViewById<TextView>(R.id.password_mismatch)

        // 패스워드 입력 상태를 모니터링
        val updatePasswordMismatchVisibility = {
            val password = passwordText.text.toString()
            val verifyPassword = verifyPasswordText.text.toString()

            if (password == verifyPassword) {
                passwordMismatchTextView.visibility = View.INVISIBLE // 패스워드 일치
            } else {
                passwordMismatchTextView.visibility = View.VISIBLE // 패스워드 불일치
            }
        }

        passwordText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                updatePasswordMismatchVisibility()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // 변경 전 작업 없음
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // 변경 중 작업 없음
            }
        })

        verifyPasswordText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                updatePasswordMismatchVisibility()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // 변경 전 작업 없음
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // 변경 중 작업 없음
            }
        })

        // 액티비티 이동
        val mainRButton = findViewById<ImageButton>(R.id.main_rbutton)
        val mainNextButton = findViewById<ImageButton>(R.id.main_nextbutton)

        mainRButton.setOnClickListener {
            // Register01Activity로 이동
            val intent = Intent(this, Register01Activity::class.java)
            startActivity(intent)
        }

        mainNextButton.setOnClickListener {
            // Register03Activity로 이동
            val intent = Intent(this, Register03Activity::class.java)
            startActivity(intent)
        }
    }
}
