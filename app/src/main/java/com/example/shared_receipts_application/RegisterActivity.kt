package com.example.shared_receipts_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {
    private lateinit var mFirebaseAuth: FirebaseAuth // 파이어 베이스 인증
    private lateinit var mDatabaseRef: DatabaseReference // 실시간 데이터 베이스
    private lateinit var mEtEmail: EditText
    private lateinit var mEtPwd: EditText
    private lateinit var mBtnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mFirebaseAuth = FirebaseAuth.getInstance()
        mDatabaseRef = FirebaseDatabase.getInstance().reference

        mEtEmail = findViewById(R.id.et_email)
        mEtPwd = findViewById(R.id.et_pwd)
        mBtnRegister = findViewById(R.id.btn_lregister)

        mBtnRegister.setOnClickListener {
            // 회원가입 처리 시작
            val strEmail = mEtEmail.text.toString().trim()
            val strPwd = mEtPwd.text.toString().trim()

            // Firebase Auth 진행
            mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPwd)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val firebaseUser: FirebaseUser? = mFirebaseAuth.currentUser
                        val account = UserAccount().apply {
                            idToken = firebaseUser?.uid
                            emailId = strEmail
                            password = strPwd
                        }
                        mDatabaseRef.child("UserAccount").child(firebaseUser?.uid ?: "").setValue(account)
                        Toast.makeText(this@RegisterActivity, "회원가입에 성공했습니다.", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@RegisterActivity, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}
