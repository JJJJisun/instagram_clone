package com.jjjjisun.instagram_clone

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jjjjisun.instagram_clone.databinding.MessageRecyclerItemBinding
import java.util.*
import kotlin.collections.ArrayList

class MessageAdapter(context: Context, val messageCardArrayList: ArrayList<MessageCard>) :
    RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    lateinit var binding: MessageRecyclerItemBinding

    fun addData(messageData: MessageCard) {
        messageCardArrayList.add(messageData)

        //갱신처리
        notifyDataSetChanged()
    }

    fun removeData(position: Int) {
        messageCardArrayList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun swapData(fromPos: Int, toPos: Int) {
        Collections.swap(messageCardArrayList, fromPos, toPos)
        notifyItemMoved(fromPos, toPos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): ViewHolder {
        binding = MessageRecyclerItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mesaageUserImg.setImageResource(messageCardArrayList.get(position).userImg)
        holder.mesaageUserTv.text = messageCardArrayList[position].name
        holder.mesaageTimeTv.text = messageCardArrayList[position].time
    }

    override fun getItemCount(): Int {
        return messageCardArrayList.size
    }

    class ViewHolder(private val binding: MessageRecyclerItemBinding): RecyclerView.ViewHolder(binding.root) {
        val mesaageUserImg = binding.messageItemUserImg
        val mesaageUserTv = binding.messageItemUserTv
        val mesaageTimeTv = binding.messageItemTimeTv
    }

}