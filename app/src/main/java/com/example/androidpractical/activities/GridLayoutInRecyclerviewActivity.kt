package com.example.androidpractical.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractical.Models.GridViewModelClass
import com.example.androidpractical.R
import com.example.androidpractical.adapter.GridViewAdapter

class GridLayoutInRecyclerviewActivity : AppCompatActivity() {

    private val data = ArrayList<GridViewModelClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_layout_in_recyclerview)

        val recyclerView: RecyclerView = findViewById(R.id.gridView)
        addItemToArrayList()
        val layoutManager = GridLayoutManager(this, 3)
        val myRecyclerViewAdapter = GridViewAdapter(data)

        recyclerView.apply {
            this.adapter = myRecyclerViewAdapter
            this.layoutManager = layoutManager
            this.addItemDecoration(RecyclerViewItemDecoration(50))
        }

        val adapter = GridViewAdapter(data)
        recyclerView.adapter = adapter
    }

    private fun addItemToArrayList() {
        data.add(
            GridViewModelClass(
                R.drawable.c_image
            )
        )
        data.add(
            GridViewModelClass(
                R.drawable.cpp_image
            )
        )
        data.add(
            GridViewModelClass(
                R.drawable.java_image
            )
        )
        data.add(
            GridViewModelClass(
                R.drawable.c_image
            )
        )
        data.add(
            GridViewModelClass(
                R.drawable.cpp_image
            )
        )
        data.add(
            GridViewModelClass(
                R.drawable.java_image
            )
        )
        data.add(
            GridViewModelClass(
                R.drawable.c_image
            )
        )
        data.add(
            GridViewModelClass(
                R.drawable.cpp_image
            )
        )
        data.add(
            GridViewModelClass(
                R.drawable.java_image
            )
        )
    }
}