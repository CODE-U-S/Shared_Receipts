package com.example.shared_receipts_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        val favoriteList = mutableListOf<Favorite>()
        val img = arrayOf(R.drawable.background_login, R.drawable.background_login, R.drawable.background_login)
        val user = arrayOf("상도동 물주먹", "폐지 줍는 다람쥐", "아브라카다브라")
        val title = arrayOf("부산 여행 가실 분", "순대국밥 먹으실 분~", "먹방유튜버")
        val data = arrayOf("2023.08.20 ~ 08.23", "2023.08.16 ~ 08.17", "2023.08.19 ~ 09.17")
        val price = arrayOf("20,000원", "34,000원", "3,400원")
        val number = arrayOf("3/4명", "3/4명", "2/4명")

        for (i in user.indices) {
            favoriteList.add(Favorite(img[i], user[i], title[i], data[i], price[i], number[i]))
        }

        val listView = findViewById<RecyclerView>(R.id.favorite_)
        listView.setHasFixedSize(true)
        listView.layoutManager = LinearLayoutManager(this)
        listView.adapter = ContactFavoriteList(favoriteList)
    }
}