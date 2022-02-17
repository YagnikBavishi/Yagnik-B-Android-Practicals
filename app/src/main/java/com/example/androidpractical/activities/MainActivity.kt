package com.example.androidpractical.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidpractical.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnUIWidgets: Button = findViewById(R.id.btnUIWidgets)
        val btnLayout: Button = findViewById(R.id.btnLayouts)
        val recyclerviewAndAdapter: Button = findViewById(R.id.btnrecyclerviewAndAdapter)

        btnUIWidgets.setOnClickListener {
            val intent = Intent(this, ButtonDemoActivity::class.java)
            startActivity(intent)
        }

        btnLayout.setOnClickListener {
            val intent = Intent(this, AllLayoutActivity::class.java)
            startActivity(intent)
        }

        recyclerviewAndAdapter.setOnClickListener {
            val intent = Intent(this, AllViewsAndAdaptersActivity::class.java)
            startActivity(intent)
        }
    }
}