package com.example.androidpractical.adapter

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractical.Models.RetrofitUserListModelClass
import com.example.androidpractical.R
import com.example.androidpractical.activities.DisplaySingleUserDataActivity
import java.util.concurrent.Executors

class RetrofitUserListAdapter(
    private val arrayList: ArrayList<RetrofitUserListModelClass.Data>,
    private var context: Activity
) :
    RecyclerView.Adapter<RetrofitUserListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_user_list, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            val url = arrayList[position].avatar
            true.also { imgView.clipToOutline = it }
            textView.text = arrayList[position].email
            textFirstName.text = arrayList[position].firstName

            val executor = Executors.newSingleThreadExecutor()
            val handler = Handler(Looper.getMainLooper())
            var image: Bitmap?
            executor.execute {
                try {
                    val userImage = java.net.URL(url).openStream()
                    image = BitmapFactory.decodeStream(userImage)

                    handler.post {
                        imgView.setImageBitmap(image)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            cardView.setOnClickListener {
                val intent = Intent(context, DisplaySingleUserDataActivity::class.java)
                intent.putExtra(context.getString(R.string.user_id), (position + 1).toString())
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imgView: ImageView = itemView.findViewById(R.id.imgView)
        val textView: TextView = itemView.findViewById(R.id.textEmail)
        val textFirstName: TextView = itemView.findViewById(R.id.textFirstName)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
    }
}