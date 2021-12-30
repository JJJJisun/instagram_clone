package com.jjjjisun.instagram_clone

import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.jjjjisun.instagram_clone.databinding.ActivityMessageRecyclerBinding

data class MessageCard(val userImg: Int, val name: String, val time: String)

class MessageRecycler : AppCompatActivity() {

    var messageCardArrayList = ArrayList<MessageCard>()

    private lateinit var messageAdapter: MessageAdapter
    lateinit var binding: ActivityMessageRecyclerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMessageRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //메세지 페이지 데이터
        for (i in 0..10) {
            messageCardArrayList.add(
                MessageCard(R.drawable.heart_user_1, "김회원", "2시간 전에 보냄")
            )
            messageCardArrayList.add(
                MessageCard(R.drawable.heart_user_3, "Waggles", "6시간 전에 보냄")
            )
            messageCardArrayList.add(
                MessageCard(R.drawable.heart_user_4, "UserName", "4시간 전에 보냄")
            )
        }

        //어댑터 연결
        messageAdapter = MessageAdapter(this, messageCardArrayList)
        binding.messageRecycler.adapter = messageAdapter

        //뒤로가기 버튼 클릭 이벤트
        binding.ibBackMessageList.setOnClickListener {
            finish()
        }

        //추가 버튼 클릭 이벤트
        binding.ivNewPost.setOnClickListener {
            messageCardArrayList.add(0, MessageCard(R.drawable.heart_user_1, "추가된 이름", "방금 추가 됨"))
            messageAdapter.addData(MessageCard(R.drawable.heart_user_1, "추가된 이름", "방금 추가 됨"))
        }


        //드래그, 스와이프 조작이 일어날 때 발생
        val itemTouchCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN, ItemTouchHelper.LEFT
        ) {
            //드래그
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val fromPos: Int = viewHolder.adapterPosition
                val toPos: Int = target.adapterPosition
                messageAdapter.swapData(fromPos, toPos)
                return true
            }

            //스와이프
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                messageAdapter.removeData(viewHolder.layoutPosition)
            }

            //스와이프 시 이미지
            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {
                val icon: Bitmap
                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                    val itemView = viewHolder.itemView
                    val height = (itemView.bottom - itemView.top).toFloat()
                    val width = height / 4
                    val paint = Paint()
                    if (dX < 0) {
                        paint.color = Color.parseColor("#ff0000")
                        val background = RectF(
                            itemView.right.toFloat() + dX,
                            itemView.top.toFloat(),
                            itemView.right.toFloat(),
                            itemView.bottom.toFloat()
                        )
                        c.drawRect(background, paint)

                        icon = BitmapFactory.decodeResource(resources, R.drawable.ic_menu_delete)
                        val iconDst = RectF(
                            itemView.right.toFloat() - 3 * width,
                            itemView.top.toFloat() + width,
                            itemView.right.toFloat() - width,
                            itemView.bottom.toFloat() - width
                        )
                        c.drawBitmap(icon, null, iconDst, null)

                    }
                }
                super.onChildDraw(
                    c,
                    recyclerView,
                    viewHolder,
                    dX,
                    dY,
                    actionState,
                    isCurrentlyActive
                )
            }

        }
        ItemTouchHelper(itemTouchCallback).attachToRecyclerView(binding.messageRecycler)
    }

}
