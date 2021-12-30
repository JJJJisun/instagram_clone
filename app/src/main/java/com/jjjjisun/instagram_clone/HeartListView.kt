package com.jjjjisun.instagram_clone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jjjjisun.instagram_clone.databinding.ActivityHeartListViewBinding

data class UserCard(val user: Int, val content: String, var isSwitched: Boolean = false)

class HeartListView : AppCompatActivity() {

    var userCardArrayList = ArrayList<UserCard>()
    private lateinit var heartAdapter: HeartAdapter
    lateinit var binding: ActivityHeartListViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHeartListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //리스트 데이터 저장
        for (i in 1..10) {
            userCardArrayList.add(
                UserCard(
                    R.drawable.heart_user_1,
                    "회원님이 알 수도 있는 AAAA_a님이 Instagram을 사용 중입니다."
                )
            )
            userCardArrayList.add(
                UserCard(
                    R.drawable.heart_user_2,
                    "회원님이 알 수도 있는 BBBB_b님이 Instagram을 사용 중입니다."
                )
            )
            userCardArrayList.add(
                UserCard(
                    R.drawable.heart_user_3,
                    "회원님이 알 수도 있는 CCCC_c님이 Instagram을 사용 중입니다."
                )
            )
        }

        //어댑터 연결
        heartAdapter = HeartAdapter(this, userCardArrayList)
        binding.listviewHeartList.adapter = heartAdapter

        //뒤로가기 버튼 클릭이벤트
        binding.ibBackHeartList.setOnClickListener {
            finish()
        }

    }
}