package com.example.androidpractical.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidpractical.R

class AllOtherViewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_other_views)

        val btnWebView: Button = findViewById(R.id.btnWebView)
        val btnScrollView: Button = findViewById(R.id.btnScrollView)
        val btnSearchViewActivity: Button = findViewById(R.id.btnSearchView)

        btnWebView.setOnClickListener {
            val intent = Intent(this, AdvanceWebViewActivity::class.java)
            startActivity(intent)
        }

        btnScrollView.setOnClickListener {
            val intent = Intent(this, ScrollViewActivity::class.java)
            startActivity(intent)
        }

        btnSearchViewActivity.setOnClickListener {
            val intent = Intent(this, SearchViewActivity::class.java)
            startActivity(intent)
        }
    }
}