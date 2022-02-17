package com.example.androidpractical.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.androidpractical.R
import com.example.androidpractical.adapter.BottomNavigationAdapter
import com.example.androidpractical.common_floder.utils.Constants.ONE
import com.example.androidpractical.common_floder.utils.Constants.TWO
import com.example.androidpractical.common_floder.utils.Constants.ZERO
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomNavigation)
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val adapter = BottomNavigationAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        bottomNavigation.setOnItemReselectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    viewPager.setCurrentItem(ZERO, true)
                }
                R.id.menu_profile -> {
                    viewPager.setCurrentItem(ONE, true)
                }
                R.id.menu_search -> {
                    viewPager.setCurrentItem(TWO, true)
                }
            }
            true
        }

        viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when(position) {
                    ZERO -> bottomNavigation.selectedItemId = R.id.menu_home
                    ONE -> bottomNavigation.selectedItemId = R.id.menu_profile
                    TWO -> bottomNavigation.selectedItemId = R.id.menu_search
                }
                super.onPageSelected(position)
            }
        })
    }
}
