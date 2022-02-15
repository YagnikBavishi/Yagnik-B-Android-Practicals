package com.example.androidpractical.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.viewpager2.widget.ViewPager2
import com.example.androidpractical.R
import com.example.androidpractical.adapter.FragmentAdapter
import com.example.androidpractical.common_floder.utils.Constants.ONE
import com.example.androidpractical.common_floder.utils.Constants.ZERO
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewpagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)

        val adapter = FragmentAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                ZERO -> tab.text = getString(R.string.recent)
                ONE -> tab.text = getString(R.string.my_favorites)
            }
        }.attach()
    }
}

