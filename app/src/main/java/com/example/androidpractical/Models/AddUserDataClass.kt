package com.example.androidpractical.Models

data class AddUserDataClass(
    var job: String = "",
    var name: String = ""
) {
    data class AddUser(
        val createdAt: String,
        val id: String,
        val job: String,
        val name: String
    )
}