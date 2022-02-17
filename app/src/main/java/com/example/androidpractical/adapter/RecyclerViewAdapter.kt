package com.example.androidpractical.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractical.Models.RecyclerViewModelClass
import com.example.androidpractical.R

class RecyclerViewAdapter(private val arrayList: ArrayList<RecyclerViewModelClass>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            imageView.setImageResource(arrayList[position].image)
            textView.text = arrayList[position].text

            checkBox.setOnClickListener {
                arrayList[position].isChecked = !arrayList[position].isChecked
                notifyItemChanged(position)
            }

            checkBox.isChecked = arrayList[position].isChecked
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val checkBox: CheckBox = itemView.findViewById(R.id.cbForRecyclerView)
    }
}