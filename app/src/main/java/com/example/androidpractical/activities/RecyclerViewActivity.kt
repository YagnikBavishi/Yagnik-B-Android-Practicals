package com.example.androidpractical.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractical.Models.RecyclerViewModelClass
import com.example.androidpractical.R
import com.example.androidpractical.adapter.RecyclerViewAdapter

class RecyclerViewActivity : AppCompatActivity() {

    private val data = ArrayList<RecyclerViewModelClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        addItemToArrayList()

        val adapter = RecyclerViewAdapter(data)
        recyclerView.adapter = adapter
    }

    private fun addItemToArrayList() {
        data.apply {
            add(
                RecyclerViewModelClass(
                    R.drawable.c_image,
                    getString(R.string.c_description),
                    false
                )
            )
            add(
                RecyclerViewModelClass(
                    R.drawable.cpp_image,
                    getString(R.string.cpp_description),
                    false
                )
            )
            add(
                RecyclerViewModelClass(
                    R.drawable.java_image,
                    getString(R.string.java_description),
                    false
                )
            )
            add(
                RecyclerViewModelClass(
                    R.drawable.swift_image,
                    getString(R.string.swift_description),
                    false
                )
            )
            add(
                RecyclerViewModelClass(
                    R.drawable.python_image,
                    getString(R.string.python_description),
                    false
                )
            )
            add(
                RecyclerViewModelClass(
                    R.drawable.c_image,
                    getString(R.string.c_description),
                    false
                )
            )
            add(
                RecyclerViewModelClass(
                    R.drawable.cpp_image,
                    getString(R.string.cpp_description),
                    false
                )
            )
            add(
                RecyclerViewModelClass(
                    R.drawable.java_image,
                    getString(R.string.java_description),
                    false
                )
            )
            add(
                RecyclerViewModelClass(
                    R.drawable.swift_image,
                    getString(R.string.swift_description),
                    false
                )
            )
            add(
                RecyclerViewModelClass(
                    R.drawable.python_image,
                    getString(R.string.python_description),
                    false
                )
            )
            add(
                RecyclerViewModelClass(
                    R.drawable.java_image,
                    getString(R.string.java_description),
                    false
                )
            )
            add(
                RecyclerViewModelClass(
                    R.drawable.swift_image,
                    getString(R.string.swift_description),
                    false
                )
            )
            add(
                RecyclerViewModelClass(
                    R.drawable.python_image,
                    getString(R.string.python_description),
                    false
                )
            )
        }
    }
}