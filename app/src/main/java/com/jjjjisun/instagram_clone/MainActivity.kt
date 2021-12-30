package com.jjjjisun.instagram_clone

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jjjjisun.instagram_clone.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val GALLERY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //메인 리사이클러_포스트 데이터
        val postList = arrayListOf(
            Post(R.drawable.my_profile, "jjjjisun", "좋아요 4개", "jjjjisun"),
            Post(R.drawable.friend_profile, "Waggles", "좋아요 255개", "Waggles"),
            Post(R.drawable.my_profile_2, "HypeSun_98", "좋아요 456개", "HypeSun_98"),
            Post(R.drawable.my_profile_3, "KarolBary", "좋아요 4개", "KarolBary"),
            Post(R.drawable.my_profile_4, "Ruffles", "좋아요 396개", "Ruffles"),
            Post(R.drawable.friend_profile, "Waggles", "좋아요 1,873개", "Waggles"),
            Post(R.drawable.my_profile, "jjjjisun", "좋아요 55개", "jjjjisun"),
            Post(R.drawable.my_profile_2, "HypeSun_98", "좋아요 10개", "HypeSun_98"),
            Post(R.drawable.my_profile_4, "Ruffles", "좋아요 9개", "Ruffles"),
        )

        val rv_post: RecyclerView = findViewById(R.id.recycler_post)
        rv_post.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_post.setHasFixedSize(true)

        rv_post.adapter = PostAdapter(postList)

        //heartList_btn 클릭 이벤트
        binding.heartListBtn.setOnClickListener {
            startActivity(Intent(this, HeartListView::class.java))
        }

        //message_btn 클릭 이벤트
        binding.messageBtn.setOnClickListener {
            startActivity(Intent(this, MessageRecycler::class.java))
        }

        //newPost_btn 클릭 이벤트
        binding.newPostBtn.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            intent.type = "image/*"
            startActivityForResult(intent, GALLERY)
        }
    }

}