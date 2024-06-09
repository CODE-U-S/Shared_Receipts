package com.example.shared_receipts_application

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shared_receipts_application.databinding.ActivityMainBinding
import com.example.shared_receipts_application.databinding.FragmentOrderBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        //네비게인션을 담은 호스트
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment

        //네비게이션 컨트롤러
        val navController = navHostFragment.navController

        //바텀 네비게이션 뷰와 네비게이션을 묶어준다.
        NavigationUI.setupWithNavController(mBinding.bottomNav, navController)



        val mainList = mutableListOf<Main>()
        val img = arrayOf(R.drawable.background_login, R.drawable.background_login, R.drawable.background_login)
        val user = arrayOf("상도동 물주먹", "폐지 줍는 다람쥐", "아브라카다브라")
        val title = arrayOf("부산 여행 가실 분", "순대국밥 먹으실 분~", "먹방유튜버")
        val data = arrayOf("2023.08.20 ~ 08.23", "2023.08.16 ~ 08.17", "2023.08.19 ~ 09.17")
        val category = arrayOf("#해운대 #맛집투어", "#밥친구 #급구", "#친구")
        val number = arrayOf("3/4명", "3/4명", "2/4명")

        for (i in user.indices) {
            mainList.add(Main(img[i], user[i], title[i], data[i], category[i], number[i]))
        }

        val listView = findViewById<RecyclerView>(R.id.main_)
        listView.setHasFixedSize(true)
        listView.layoutManager = GridLayoutManager(this, 2)
        listView.adapter = ContactMainList(mainList)
    }
}