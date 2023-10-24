package com.example.shared_receipts_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // LoginAvtivity를 클릭하면 Register01Activity로 이동
        val loginButton = findViewById<ImageButton>(R.id.main_joinbutton)
        loginButton.setOnClickListener {
            val intent = Intent(this, Register01Activity::class.java)
            startActivity(intent)
        }
    }

}
