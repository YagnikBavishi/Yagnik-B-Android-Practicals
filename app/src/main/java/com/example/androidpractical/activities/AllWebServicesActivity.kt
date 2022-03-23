package com.example.androidpractical.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidpractical.R

class AllWebServicesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_web_services)

        val btnLoginWithoutThirdParty: Button = findViewById(R.id.btnLoginWithoutThirdParty)
        val btnRetrofit: Button = findViewById(R.id.btnRetrofit)

        btnLoginWithoutThirdParty.setOnClickListener {
            val intent = Intent(this, LoginScreenActivity::class.java)
            startActivity(intent)
        }

        btnRetrofit.setOnClickListener {
            val intent = Intent(this, RetrofitLoginActivity::class.java)
            startActivity(intent)
        }
    }
}