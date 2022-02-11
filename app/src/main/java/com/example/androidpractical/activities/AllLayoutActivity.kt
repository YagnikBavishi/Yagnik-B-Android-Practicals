package com.example.androidpractical.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidpractical.R

class AllLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_layout)

        val btnLinearLayout: Button = findViewById(R.id.btnLinearLayout)
        val btnRelativeLayout: Button = findViewById(R.id.btnRelativeLayout)
        val btnConstraintLayout: Button = findViewById(R.id.btnConstraintLayout)
        val btnTableLayout: Button = findViewById(R.id.btnTableLayout)
        val btnGridLayout: Button = findViewById(R.id.btnGridLayout)
        val btnFrameLayout: Button = findViewById(R.id.btnFrameLayout)
        val btnWebView: Button = findViewById(R.id.btnWebLayout)

        btnLinearLayout.setOnClickListener {
            val intent = Intent(this, LinearLayoutActivity::class.java)
            startActivity(intent)
        }

        btnRelativeLayout.setOnClickListener {
            val intent = Intent(this, RelativeLayoutActivity::class.java)
            startActivity(intent)
        }

        btnConstraintLayout.setOnClickListener {
            val intent = Intent(this, ConstraintLayoutActivity::class.java)
            startActivity(intent)
        }

        btnTableLayout.setOnClickListener {
            val intent = Intent(this, TableLayoutActivity::class.java)
            startActivity(intent)
        }

        btnGridLayout.setOnClickListener {
            val intent = Intent(this, GridLayoutActivity::class.java)
            startActivity(intent)
        }

        btnFrameLayout.setOnClickListener {
            val intent = Intent(this, FrameLayoutActivity::class.java)
            startActivity(intent)
        }

        btnWebView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }
    }
}