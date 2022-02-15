package com.example.androidpractical.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.androidpractical.Models.LanguageModelClass
import com.example.androidpractical.R

class ListAdapter(
    private val context: Activity,
    private val arraylist: ArrayList<LanguageModelClass>
) : ArrayAdapter<LanguageModelClass>(context, R.layout.custom_list, arraylist) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewHolder: ViewHolder
        val inflater = context.layoutInflater
        val rowValue: View = inflater.inflate(R.layout.custom_list, null, true)

        viewHolder = ViewHolder(rowValue)
        rowValue.tag = viewHolder

        viewHolder.apply {
            tvTitle.text = arraylist[position].title
            ivImageView.setImageResource(arraylist[position].icon)
            tvDescription.text = arraylist[position].description
        }

        return rowValue
    }

    private class ViewHolder(view: View) {
        val tvTitle: TextView = view.findViewById(R.id.title)
        val ivImageView: ImageView = view.findViewById(R.id.icon)
        val tvDescription: TextView = view.findViewById(R.id.description)
    }
}