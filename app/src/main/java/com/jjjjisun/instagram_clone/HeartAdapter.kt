package com.jjjjisun.instagram_clone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.jjjjisun.instagram_clone.databinding.ListviewHeartItemBinding

class HeartAdapter(context: Context, private val userCardArrayList: ArrayList<UserCard>) :
    BaseAdapter() {

    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    lateinit var binding: ListviewHeartItemBinding

    override fun getCount(): Int = userCardArrayList.size

    override fun getItem(position: Int): Any = userCardArrayList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        binding = ListviewHeartItemBinding.inflate(inflater, parent, false)

        //리스트뷰 유저이미지 변경
        binding.listItemUserImg.setImageResource(userCardArrayList.get(position).user)
        //리스트뷰 텍스트 변경
        binding.listItemUserTv.text = userCardArrayList[position].content

        //스위치 초기화
        binding.listItemUserCb.setChecked(userCardArrayList[position].isSwitched)
        binding.listItemUserCb.setOnCheckedChangeListener { CompoundButton, onSwitch ->
            userCardArrayList[position].isSwitched = onSwitch
        }

        return binding.root

    }
}