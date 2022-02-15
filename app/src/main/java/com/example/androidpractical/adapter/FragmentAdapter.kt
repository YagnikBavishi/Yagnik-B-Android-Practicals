package com.example.androidpractical.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.androidpractical.common_floder.utils.Constants.ONE
import com.example.androidpractical.common_floder.utils.Constants.TWO
import com.example.androidpractical.common_floder.utils.Constants.ZERO
import com.example.androidpractical.fragments.RecentFragment
import com.example.androidpractical.fragments.FavoritesFragment

class FragmentAdapter(supportFragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(supportFragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return TWO
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            ZERO -> {
                RecentFragment()
            }
            ONE -> {
                FavoritesFragment()
            }
            else -> {
                RecentFragment()
            }
        }
    }
}