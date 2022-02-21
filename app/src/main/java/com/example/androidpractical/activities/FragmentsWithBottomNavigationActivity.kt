package com.example.androidpractical.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.androidpractical.R
import com.example.androidpractical.fragments.AddMessageFragment
import com.example.androidpractical.fragments.GalleryFragment
import com.example.androidpractical.fragments.ViewMessageFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class FragmentsWithBottomNavigationActivity : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments_with_bottom_navigation)

        bottomNavigation = findViewById(R.id.bottomNavigation)
        val switchButton: SwitchCompat = findViewById(R.id.switchButton)

        val checkSwitchIsOn = intent.getBooleanExtra(getString(R.string.switchbutton), false)
        switchButton.isChecked = checkSwitchIsOn

        switchButton.setOnCheckedChangeListener { _, isChecked ->
            val intent = Intent(this, FragmentsWithBottomNavigationActivity::class.java)
            intent.putExtra(getString(R.string.switchbutton), isChecked)
            startActivity(intent)
            finish()
        }

        if (checkSwitchIsOn) {
            title = getString(R.string.switch_to_jetpack_compose)
            startActivityWithJetPack()
        } else {
            startActivityWithoutJetPack()
        }
    }

    private fun startActivityWithoutJetPack() {
        setTheFragments(GalleryFragment())
        bottomNavigation.setOnItemReselectedListener {
            when (it.itemId) {
                R.id.galleryFragment -> {
                    setTheFragments(GalleryFragment())
                }
                R.id.addMessageFragment -> {
                    setTheFragments(AddMessageFragment())
                }
                R.id.viewMessageFragment -> {
                    setTheFragments(ViewMessageFragment())
                }
            }
        }
    }

    private fun startActivityWithJetPack() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigation)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }

    private fun setTheFragments(newFragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.main_nav_host_fragment, newFragment)
        }
    }
}