package com.example.androidpractical.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractical.R

class AllActivityIntentAndFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_intent_and_fragment)

        val btnFragment: Button = findViewById(R.id.btnFragments)
        val btnFragmentsWithBottomNavigation: Button = findViewById(R.id.btnFragmentsWithBottomNavigation)

        btnFragment.setOnClickListener {
            val intent = Intent(this, FragmentExampleActivity::class.java)
            startActivity(intent)
        }

        btnFragmentsWithBottomNavigation.setOnClickListener {
            val intent = Intent(this, FragmentsWithBottomNavigationActivity::class.java)
            startActivity(intent)
        }
    }
}