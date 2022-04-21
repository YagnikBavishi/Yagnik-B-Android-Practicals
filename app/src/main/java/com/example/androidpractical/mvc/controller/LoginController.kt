package com.example.androidpractical.mvc.controller

import com.example.androidpractical.Models.LoginRequest
import com.example.androidpractical.`interface`.ApiInterface
import com.example.androidpractical.common_floder.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginController(private val loginResult: LoginInterface.LoginResult): LoginInterface {
    override fun login(userEmail: String, userPassword: String) {
        val apiInterface = ApiInterface.getRetrofitObject().create(ApiInterface::class.java)
        val loginRequest = LoginRequest()
        loginRequest.email = userEmail
        loginRequest.password = userPassword
        val loginAPI = apiInterface.verifyLogin(loginRequest)
        loginAPI.enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                response.body()
                if (response.code() == Constants.TWOHUNDRED) {
                    loginResult.loginSuccess()
                } else {
                   loginResult.loginUnSuccess()
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
            }
        })
    }
}