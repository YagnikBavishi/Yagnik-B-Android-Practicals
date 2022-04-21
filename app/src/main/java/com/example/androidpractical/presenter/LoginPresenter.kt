package com.example.androidpractical.presenter

import com.example.androidpractical.`interface`.ApiInterface
import com.example.androidpractical.common_floder.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(private val loginResult: LoginResultInterface,
                     override var email: String,
                     override var password: String
) : LoginPresenterInterface, LoginModelInterface {

    override fun doLogin(userEmail: String, userPassword: String) {
        val apiInterface = ApiInterface.getRetrofitObject().create(ApiInterface::class.java)
        val loginRequest = LoginModelClass(email = userEmail, password = userPassword)
        email = userEmail
        password = userPassword
        val loginAPI = apiInterface.loginWithMVC(loginRequest)
        loginAPI.enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                response.body()
                when(response.code()) {
                    Constants.TWOHUNDRED -> loginResult.loginSuccessful()
                    else -> loginResult.loginUnSuccessful()
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
            }
        })
    }
}