package com.example.shared_receipts_application.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shared_receipts_application.ContactMainList
import com.example.shared_receipts_application.Main
import com.example.shared_receipts_application.R
import com.example.shared_receipts_application.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var mBinding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        mBinding = binding
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        mBinding?.let {
            val listView = it.root.findViewById<RecyclerView>(R.id.main_)
            listView.setHasFixedSize(true)
            listView.layoutManager = GridLayoutManager(requireContext(), 2)
            listView.adapter = ContactMainList(mainList)
        }
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}
