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
        val btnRecyclerviewAndAdapter: Button = findViewById(R.id.btnrecyclerviewAndAdapter)
        val btnActivityIntentFragment: Button = findViewById(R.id.btnActivityIntentFragment)
        val btnOtherViews: Button = findViewById(R.id.btnOtherViews)
        val btnAllWebServices: Button = findViewById(R.id.btnWebServices)

        btnUIWidgets.setOnClickListener {
            val intent = Intent(this, ButtonDemoActivity::class.java)
            startActivity(intent)
        }

        btnLayout.setOnClickListener {
            val intent = Intent(this, AllLayoutActivity::class.java)
            startActivity(intent)
        }

        btnRecyclerviewAndAdapter.setOnClickListener {
            val intent = Intent(this, AllViewsAndAdaptersActivity::class.java)
            startActivity(intent)
        }

        btnActivityIntentFragment.setOnClickListener {
            val intent = Intent(this, AllActivityIntentAndFragmentActivity::class.java)
            startActivity(intent)
        }

        btnOtherViews.setOnClickListener {
            val intent = Intent(this, AllOtherViewsActivity::class.java)
            startActivity(intent)
        }

        btnAllWebServices.setOnClickListener {
            val intent = Intent(this, AllWebServicesActivity::class.java)
            startActivity(intent)
        }
    }
}