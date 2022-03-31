package com.example.androidpractical.adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractical.Models.UserListModelClass
import com.example.androidpractical.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserListAdapter(private val arrayList: ArrayList<UserListModelClass>) :
    RecyclerView.Adapter<UserListAdapter.ViewHolder>() {
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
            val url = arrayList[position].image
            imgView.clipToOutline = true
            var image: Bitmap?
            GlobalScope.launch(Dispatchers.IO) {
                val userImage = java.net.URL(url).openStream()
                image = BitmapFactory.decodeStream(userImage)

                withContext(Dispatchers.Main) {
                    textEmail.text = arrayList[position].email
                    textFirstName.text = arrayList[position].firstName
                    imgView.setImageBitmap(image)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textEmail: TextView = itemView.findViewById(R.id.textEmail)
        val textFirstName: TextView = itemView.findViewById(R.id.textFirstName)
        val imgView: ImageView = itemView.findViewById(R.id.imgView)
    }
}
