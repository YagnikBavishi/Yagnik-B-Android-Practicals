package com.example.androidpractical.Models

import com.google.gson.annotations.SerializedName

data class SingleUserDataClass(
    val `data`: Data,
    val support: Support
) {
    data class Data(
        val avatar: String,
        var email: String,
        @SerializedName("first_name")
        var firstName: String,
        val id: Int,
        @SerializedName("last_name")
        val lastName: String
    )
    data class Support(
        val text: String,
        val url: String
    )
}