package com.example.shared_receipts_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.shared_receipts_application.databinding.ActivityMainBinding
import com.example.shared_receipts_application.databinding.ActivityNavitaionBinding

class NavitaionActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityNavitaionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityNavitaionBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment

        //네비게이션 컨트롤러
        val navController = navHostFragment.navController

        //바텀 네비게이션 뷰와 네비게이션을 묶어준다.
        NavigationUI.setupWithNavController(mBinding.bottomNav, navController)
    }
}