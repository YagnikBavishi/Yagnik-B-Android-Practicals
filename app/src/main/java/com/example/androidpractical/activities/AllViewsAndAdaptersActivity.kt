package com.example.androidpractical.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidpractical.R

class AllViewsAndAdaptersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_views_and_adapters)

        val btnListViewWithAdapter: Button = findViewById(R.id.btnListViewWithAdapter)
        val btnRecyclerView: Button = findViewById(R.id.btnRecyclerView)
        val btnGridViewWithRecycler: Button = findViewById(R.id.btnGridViewWithRecycler)
        val btnViewPager: Button = findViewById(R.id.btnViewPager)
        val btnBottomNavigation: Button = findViewById(R.id.btnBottomNavigation)

        btnListViewWithAdapter.setOnClickListener {
            val intent = Intent(this, ListViewActivity::class.java)
            startActivity(intent)
        }

        btnRecyclerView.setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }

        btnGridViewWithRecycler.setOnClickListener {
            val intent = Intent(this, GridLayoutInRecyclerviewActivity::class.java)
            startActivity(intent)
        }

        btnViewPager.setOnClickListener {
            val intent = Intent(this, ViewpagerActivity::class.java)
            startActivity(intent)
        }

        btnBottomNavigation.setOnClickListener {
            val intent = Intent(this, BottomNavigationActivity::class.java)
            startActivity(intent)
        }
    }
}