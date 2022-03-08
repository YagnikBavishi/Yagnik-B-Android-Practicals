package com.example.androidpractical.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.commit
import com.example.androidpractical.R
import com.example.androidpractical.fragments.FavoritesFragment
import com.example.androidpractical.fragments.RecentFragment

class FragmentExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_example)
        title = getString(R.string.btn_fragment)

        val btnHomeFragment: Button = findViewById(R.id.btnHomeFragment)
        val btnProfileFragment: Button = findViewById(R.id.btnProfileFragment)

        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
        btnHomeFragment.setOnClickListener {
            fragmentManager.commit {
                replace(android.R.id.content, RecentFragment())
                addToBackStack(getString(R.string.add_back_stack_name))

            }
        }

        btnProfileFragment.setOnClickListener {
            fragmentManager.commit {
                replace(android.R.id.content, FavoritesFragment())
                addToBackStack(getString(R.string.add_back_stack_name))
            }
        }
    }
}