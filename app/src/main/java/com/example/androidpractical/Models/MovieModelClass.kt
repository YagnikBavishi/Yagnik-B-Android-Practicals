package com.example.androidpractical.Models

data class MovieModelClass(
    val movieName: String,
    val movieImage: Int,
    val movieRealName: String,
    val movieFirstAppearance: String,
    val movieTeam: String,
    val movieCreatedBy: String,
    val moviePublisher: String,
    val movieBio: String,
    var expandable: Boolean = false
)