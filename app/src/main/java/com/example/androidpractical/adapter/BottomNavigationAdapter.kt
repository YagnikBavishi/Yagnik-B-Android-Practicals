package com.example.androidpractical.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.androidpractical.common_floder.utils.Constants.ONE
import com.example.androidpractical.common_floder.utils.Constants.THREE
import com.example.androidpractical.common_floder.utils.Constants.TWO
import com.example.androidpractical.fragments.RecentFragment
import com.example.androidpractical.fragments.SearchFragment
import com.example.androidpractical.fragments.FavoritesFragment

class BottomNavigationAdapter(supportFragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(supportFragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return THREE
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            ONE -> return FavoritesFragment()
            TWO -> return SearchFragment()
        }
        return RecentFragment()
    }
}