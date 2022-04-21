package com.example.androidpractical.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.androidpractical.`interface`.ApiInterface
import com.example.androidpractical.Models.LoginRequest
import com.example.androidpractical.R
import com.example.androidpractical.common_floder.utils.Constants
import retrofit2.*

class RetrofitLoginActivity : AppCompatActivity() {

    private lateinit var tvEmail: EditText
    private lateinit var tvPassWord: EditText
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_login)

        tvEmail = findViewById(R.id.tfEmail)
        tvPassWord = findViewById(R.id.tfPassword)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnSubmit.setOnClickListener {
            callLoginAPI()
        }
    }

    private fun callLoginAPI() {
        val apiInterface = ApiInterface.getRetrofitObject().create(ApiInterface::class.java)
        val loginRequest = LoginRequest()
        loginRequest.email = tvEmail.text.toString()
        loginRequest.password = tvPassWord.text.toString()
        val loginAPI = apiInterface.verifyLogin(loginRequest)
        loginAPI.enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                response.body()
                if (response.code() == Constants.TWOHUNDRED) {
                    val intent =
                        Intent(this@RetrofitLoginActivity, RetrofitUserDataActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@RetrofitLoginActivity,
                        getString(R.string.user_not_valid),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
            }
        })
    }
}