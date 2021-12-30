package com.jjjjisun.instagram_clone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(val postList: ArrayList<Post>) :
    RecyclerView.Adapter<PostAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_recycler_item, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostAdapter.CustomViewHolder, position: Int) {
        holder.userImg.setImageResource(postList.get(position).userImg)
        holder.nameTop.text = postList.get(position).nameTop
        holder.like.text = postList.get(position).like
        holder.nameBotton.text = postList.get(position).nameBottom
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userImg = itemView.findViewById<ImageButton>(R.id.profile_image)
        val nameTop = itemView.findViewById<TextView>(R.id.profile_name_top)
        val like = itemView.findViewById<TextView>(R.id.like_count)
        val nameBotton = itemView.findViewById<TextView>(R.id.profile_name_Bottom)
    }

}