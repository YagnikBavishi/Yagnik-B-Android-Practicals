package com.example.androidpractical.presenter

data class LoginModelClass(
     override var email: String ,
     override var password: String
) : LoginModelInterface