package com.example.shared_receipts_application

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MypageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        val mypageLogoutButton = findViewById<Button>(R.id.mypagelogout)

        mypageLogoutButton.setOnClickListener {
            val myIntent = Intent(this, LoginActivity::class.java)
            startActivity(myIntent)
        }

        val mypageUseroutButton = findViewById<Button>(R.id.mypageuserout)

        mypageUseroutButton.setOnClickListener {
            val myIntent = Intent(this, DropOutActivity::class.java)
            startActivity(myIntent)
        }
    }
}