package com.example.androidpractical.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidpractical.R
import com.example.androidpractical.mvc.MVCArchitecture
import com.example.androidpractical.mvvm.MVVMArchitecture

class AllArchitectureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_architecture)

        val btnMVCArchitecture: Button = findViewById(R.id.btnMVCArchitecture)
        val btnMVPArchitecture: Button = findViewById(R.id.btnMVPArchitecture)
        val btnMVVMArchitecture: Button = findViewById(R.id.btnMVVMArchitecture)

        btnMVCArchitecture.setOnClickListener {
            startActivity(Intent(this, MVCArchitecture::class.java))
        }

        btnMVPArchitecture.setOnClickListener {
            startActivity(Intent(this, MVPArchitectureActivity::class.java))
        }

        btnMVVMArchitecture.setOnClickListener {
            startActivity(Intent(this, MVVMArchitecture::class.java))
        }
    }
}