package com.example.androidpractical.mvvm

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageProfile")
fun ImageView.imageProfile(url: String) {
    Glide.with(this.context).load(url).into(this)
}

//TODO("Implement Later")
//@InverseBindingAdapter(attribute = "android:text")
//fun getData(view: TextView): String {
//    return view.text.toString().uppercase()
//}