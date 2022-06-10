package com.example.androidpractical.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractical.R
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCenter.start(
            application, "32a39a79-189c-4386-a53a-4d5595d1de67",
            Analytics::class.java, Crashes::class.java
        )
        val btnUIWidgets: Button = findViewById(R.id.btnUIWidgets)
        val btnLayout: Button = findViewById(R.id.btnLayouts)
        val btnRecyclerviewAndAdapter: Button = findViewById(R.id.btnrecyclerviewAndAdapter)
        val btnActivityIntentFragment: Button = findViewById(R.id.btnActivityIntentFragment)
        val btnOtherViews: Button = findViewById(R.id.btnOtherViews)
        val btnAllWebServices: Button = findViewById(R.id.btnWebServices)
        val btnArchitecture: Button = findViewById(R.id.btnArchitecture)
        val btnPermission: Button = findViewById(R.id.btnPermissionModel)

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

        btnArchitecture.setOnClickListener {
            val intent = Intent(this, AllArchitectureActivity::class.java)
            startActivity(intent)
        }

        btnPermission.setOnClickListener {
            startActivity(Intent(this, AndroidPermissionModelActivity::class.java))
        }
    }
}