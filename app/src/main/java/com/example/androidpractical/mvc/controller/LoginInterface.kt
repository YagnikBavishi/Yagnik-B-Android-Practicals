package com.example.androidpractical.mvc.controller

interface LoginInterface {

    fun login(userEmail: String, userPassword: String)

    interface LoginResult {
        fun loginSuccess()
        fun loginUnSuccess()
    }
}
