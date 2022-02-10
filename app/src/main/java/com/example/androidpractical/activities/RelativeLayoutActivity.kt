package com.example.androidpractical.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.androidpractical.R

class RelativeLayoutActivity : AppCompatActivity() {

    private val arrayList: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_layout)
        setTitle(R.string.btnRelativeLayout)

        val spinner: Spinner = findViewById(R.id.spinner)
        val submitButton: Button = findViewById(R.id.btnSendFeedback)

        addItemToArrayList()

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayList)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val tutorialsName: String = parent.getItemAtPosition(position).toString()
                Toast.makeText(parent.context, "Selected: $tutorialsName", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        submitButton.setOnClickListener {
            val toast = Toast.makeText(
                applicationContext,
                "Feedback Submitted..",
                Toast.LENGTH_SHORT
            )
            toast.show()
        }
    }

    private fun addItemToArrayList() {
        arrayList.add(getString(R.string.good))
        arrayList.add(getString(R.string.bad))
        arrayList.add(getString(R.string.vary_Good))
        arrayList.add(getString(R.string.medium))
    }
}