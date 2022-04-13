package com.example.androidpractical.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.androidpractical.R
import com.example.androidpractical.common_floder.utils.Constants
import com.example.androidpractical.presenter.LoginResultInterface
import com.example.androidpractical.presenter.LoginPresenter

class MVPArchitectureActivity : AppCompatActivity(), LoginResultInterface {

    private lateinit var tvEmail: EditText
    private lateinit var tvPassWord: EditText
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvparchitecture)

        tvEmail = findViewById(R.id.tfEmail)
        tvPassWord = findViewById(R.id.tfPassword)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnSubmit.setOnClickListener {
            checkLoginCredential()
        }
    }

    private fun checkLoginCredential() {
        val loginPresenter = LoginPresenter(this,"","")
        val userEmail: String = tvEmail.text.toString()
        val userPassword: String = tvPassWord.text.toString()
        loginPresenter.doLogin(userEmail, userPassword)
    }

    override fun loginSuccessful() {
        Toast.makeText(this, Constants.LOGIN_SUCCESSFUL, Toast.LENGTH_SHORT).show()
    }

    override fun loginUnSuccessful() {
        Toast.makeText(this, Constants.LOGIN_UNSUCCESSFUL, Toast.LENGTH_SHORT).show()
    }
}