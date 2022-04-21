package com.example.androidpractical.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.androidpractical.R
import com.example.androidpractical.common_floder.utils.Constants
import com.example.androidpractical.mvc.controller.LoginController
import com.example.androidpractical.mvc.controller.LoginInterface

class MVCArchitecture : AppCompatActivity(), LoginInterface.LoginResult {

    private lateinit var tvEmail: EditText
    private lateinit var tvPassWord: EditText
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvcarchitecture)

        tvEmail = findViewById(R.id.tfEmail)
        tvPassWord = findViewById(R.id.tfPassword)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnSubmit.setOnClickListener {
            checkLoginCredential()
        }
    }

    private fun checkLoginCredential() {
        val loginController = LoginController(this)
        loginController.login(tvEmail.text.toString(), tvPassWord.text.toString())
    }

    override fun loginSuccess() {
        Toast.makeText(this, Constants.LOGIN_SUCCESSFUL, Toast.LENGTH_SHORT).show()
    }

    override fun loginUnSuccess() {
        Toast.makeText(this, Constants.LOGIN_UNSUCCESSFUL, Toast.LENGTH_SHORT).show()
    }
}