package com.example.androidpractical.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractical.Models.MovieModelClass
import com.example.androidpractical.R
import com.example.androidpractical.adapter.MovieAdapter

class SearchFragment : Fragment() {

    private val modelList = ArrayList<MovieModelClass>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_search, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.searchRecyclerView)

        addData()

        val adapter = MovieAdapter(modelList)
        recyclerView.adapter = adapter
        return view
    }

    private fun addData() {
        modelList.apply {
            add(
                MovieModelClass(
                    getString(R.string.captainAmerica),
                    R.drawable.captainamerica,
                    getString(R.string.captaion_amrica_real_name),
                    getString(R.string.captainAmericaFA),
                    getString(R.string.avengers),
                    getString(R.string.captaion_amrica_created_by),
                    getString(R.string.captaion_amrica_publisher),
                    getString(R.string.captaion_amrica_bio)
                )
            )
            add(
                MovieModelClass(
                    getString(R.string.ironMan),
                    R.drawable.ironman,
                    getString(R.string.iron_man_real_name),
                    getString(R.string.ironManFA),
                    getString(R.string.avengers),
                    getString(R.string.iron_man_created_by),
                    getString(R.string.iron_man_publisher),
                    getString(R.string.iron_man_bio)
                )
            )
            add(
                MovieModelClass(
                    getString(R.string.wolvarine),
                    R.drawable.logan,
                    getString(R.string.wolvarine_real_name),
                    getString(R.string.wolvarineFA),
                    getString(R.string.x_men),
                    getString(R.string.wolvarine_created_by),
                    getString(R.string.wolvarine_publisher),
                    getString(R.string.wolvarine_bio)
                )
            )
            add(
                MovieModelClass(
                    getString(R.string.spiderman),
                    R.drawable.spiderman,
                    getString(R.string.spiderman_real_name),
                    getString(R.string.spidermanFA),
                    getString(R.string.avengers),
                    getString(R.string.spiderman_created_by),
                    getString(R.string.spiderman_publisher),
                    getString(R.string.spiderman_bio)
                )
            )
            add(
                MovieModelClass(
                    getString(R.string.thor),
                    R.drawable.thor,
                    getString(R.string.thor_real_name),
                    getString(R.string.thorFA),
                    getString(R.string.avengers),
                    getString(R.string.thor_created_by),
                    getString(R.string.thor_publisher),
                    getString(R.string.thor_bio)
                )
            )
        }
    }
}