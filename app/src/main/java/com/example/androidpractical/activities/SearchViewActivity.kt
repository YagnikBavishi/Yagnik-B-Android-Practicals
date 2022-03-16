package com.example.androidpractical.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractical.Models.MovieModelClass
import com.example.androidpractical.R
import com.example.androidpractical.adapter.MovieAdapter

class SearchViewActivity : AppCompatActivity() {

    private var data = ArrayList<MovieModelClass>()
    private var adapter: MovieAdapter = MovieAdapter(data)
    private var filterArray: ArrayList<MovieModelClass> = arrayListOf()
    lateinit var recyclerView: RecyclerView
    lateinit var tvNotFoundText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_view)

        val searchView: SearchView = findViewById(R.id.searchView)
        tvNotFoundText = findViewById(R.id.tvNotFoundText)

        tvNotFoundText.visibility = TextView.INVISIBLE

        searchView.queryHint = getString(R.string.search)
        recyclerView= findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addItemToArrayList()
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                tvNotFoundText.visibility = TextView.INVISIBLE
                search(newText)
                return false
            }
        })
    }

    private fun search(text: String?) {
        filterArray = arrayListOf()
        text?.let {
            data.forEach { data ->
                if (data.movieName.contains(text, true)) {
                    tvNotFoundText.visibility = TextView.INVISIBLE
                    filterArray.add(data)
                }
                if (filterArray.isEmpty()) {
                    tvNotFoundText.visibility = TextView.VISIBLE
                }
            }
            updateRecyclerView()
        }
    }

    private fun updateRecyclerView() {
        recyclerView.apply {
            adapter = MovieAdapter(filterArray)
            recyclerView.adapter = adapter
        }
    }

    private fun addItemToArrayList() {
        data.apply {
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