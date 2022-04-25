package com.example.androidpractical.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import com.example.androidpractical.R
import com.example.androidpractical.databinding.ActivityNavigationBinding
import com.google.android.material.snackbar.Snackbar
import com.shashank.sony.fancytoastlib.FancyToast

class NavigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.contentNavigation.toolbar)
        toggle = ActionBarDrawerToggle(this, binding.drawerView, R.string.open, R.string.close)
        binding.drawerView.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.contentNavigation.floatingActionButton.setOnClickListener { view ->
            Snackbar.make(view, getString(R.string.toast_snack_bar), Snackbar.LENGTH_SHORT)
                .setAction(getString(R.string.btn_action)) {
                    FancyToast.makeText(
                        this, getString(R.string.toast_message), FancyToast.LENGTH_SHORT,
                        FancyToast.INFO, false
                    )
                        .show()
                }
                .setBackgroundTint(ContextCompat.getColor(this, R.color.navyBlue))
                .setActionTextColor(ContextCompat.getColor(this, R.color.black))
                .show()
        }

        binding.navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navCamera -> FancyToast.makeText(
                    this, getString(R.string.toast_camera), FancyToast.LENGTH_SHORT,
                    FancyToast.INFO, false
                )
                    .show()
                R.id.navGallery -> FancyToast.makeText(
                    this, getString(R.string.toast_gallery), FancyToast.LENGTH_SHORT,
                    FancyToast.INFO, false
                )
                    .show()
                R.id.navSearch -> FancyToast.makeText(
                    this, getString(R.string.toast_search), FancyToast.LENGTH_SHORT,
                    FancyToast.INFO, false
                )
                    .show()
                R.id.TextInputLayout -> startActivity(
                    Intent(
                        this,
                        TextInputLayoutActivity::class.java
                    )
                )
            }
            binding.drawerView.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}