package com.example.androidpractical.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.androidpractical.Models.LanguageModelClass
import com.example.androidpractical.R
import com.example.androidpractical.adapter.ListAdapter
import android.widget.AdapterView.OnItemClickListener

class ListViewActivity : AppCompatActivity() {

    private val list: ArrayList<LanguageModelClass> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val listView: ListView = findViewById(R.id.listView)

        addItemToArrayList()

        val listAdapter = ListAdapter(this, list)
        listView.adapter = listAdapter

        listView.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                Toast.makeText(
                    applicationContext,
                    "Click ListItem Number $position", Toast.LENGTH_SHORT
                )
                    .show()
            }
    }

    private fun addItemToArrayList() {
        list.apply {
            add(
                LanguageModelClass(
                    getString(R.string.c_language_name),
                    getString(R.string.c_description),
                    R.drawable.c_image
                )
            )
            add(
                LanguageModelClass(
                    getString(R.string.cpp_language_name),
                    getString(R.string.cpp_description),
                    R.drawable.cpp_image
                )
            )
            add(
                LanguageModelClass(
                    getString(R.string.java_language_name),
                    getString(R.string.java_description),
                    R.drawable.java_image
                )
            )
            add(
                LanguageModelClass(
                    getString(R.string.swift_language_name),
                    getString(R.string.swift_description),
                    R.drawable.swift_image
                )
            )
            add(
                LanguageModelClass(
                    getString(R.string.python_language_name),
                    getString(R.string.python_description),
                    R.drawable.python_image
                )
            )
        }
    }
}