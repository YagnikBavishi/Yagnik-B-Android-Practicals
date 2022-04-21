package com.example.androidpractical.mvvm.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidpractical.Models.LoginRequest
import com.example.androidpractical.`interface`.ApiInterface
import com.example.androidpractical.common_floder.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel: ViewModel() {

    val message = MutableLiveData<String>()
    private var toastMessage: String = ""
    val userEmail = MutableLiveData<String>()
    val userPassword = MutableLiveData<String>()
    val userProfile = MutableLiveData(Constants.IMAGE_URL)

    fun login() {
        val apiInterface = ApiInterface.getRetrofitObject().create(ApiInterface::class.java)
        val loginRequest = LoginRequest()
        loginRequest.email = (userEmail.value ?: Constants.GMAIL)
        loginRequest.password = (userPassword.value ?: Constants.PASSWORD)
        val loginAPI = apiInterface.verifyLogin(loginRequest)
        loginAPI.enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                response.body()
                toastMessage = when(response.code()) {
                    Constants.TWOHUNDRED -> Constants.LOGIN_SUCCESSFUL
                    else ->  Constants.LOGIN_UNSUCCESSFUL
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
            }
        })
        message.postValue(toastMessage)
    }
}