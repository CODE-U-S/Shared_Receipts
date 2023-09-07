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


}
