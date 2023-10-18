package com.example.shared_receipts_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.content.Intent

class Register03Activity : AppCompatActivity() {
    private lateinit var timerTextView: TextView
    private lateinit var passwordText: EditText
    private lateinit var certificationCompletedText: TextView
    private var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register03)

        timerTextView = findViewById(R.id.timerTextView)
        passwordText = findViewById(R.id.password_text)
        certificationCompletedText = findViewById(R.id.certification_completed)

        // 3분(180000 밀리초) 타이머 생성
        timer = object : CountDownTimer(180000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // 타이머가 감소하는 동안 실행됨
                val minutes = (millisUntilFinished / 60000).toInt()
                val seconds = (millisUntilFinished % 60000 / 1000).toInt()
                timerTextView.text = String.format("%02d:%02d", minutes, seconds)
            }

            override fun onFinish() {
                // 타이머가 종료될 때 실행됨
                timerTextView.text = "00:00"
                // 비밀번호 자동 입력 및 텍스트뷰 표시
                passwordText.setText("1234")
                certificationCompletedText.visibility = View.VISIBLE
            }
        }

        // register03_sendbutton를 클릭할 때 타이머 시작
        val sendButton = findViewById<ImageButton>(R.id.register03_sendbutton)
        sendButton.setOnClickListener {
            // timerTextView를 보이도록 변경
            timerTextView.visibility = View.VISIBLE
            timer?.start()

            // 3초 뒤에 비밀번호 입력 및 텍스트뷰 표시
            Handler().postDelayed({
                passwordText.setText("1234")
                certificationCompletedText.visibility = View.VISIBLE
            }, 3000)
        }

        // register03_loginbutton를 클릭하면 LoginActivity로 이동
        val loginButton = findViewById<ImageButton>(R.id.register03_loginbutton)
        loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel() // 액티비티가 파괴될 때 타이머도 취소
    }
}
