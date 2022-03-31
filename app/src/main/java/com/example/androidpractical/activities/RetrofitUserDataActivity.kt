package com.example.androidpractical.activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractical.`interface`.ApiInterface
import com.example.androidpractical.Models.AddUserDataClass
import com.example.androidpractical.Models.RetrofitUserListModelClass
import com.example.androidpractical.R
import com.example.androidpractical.adapter.RetrofitUserListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class RetrofitUserDataActivity : AppCompatActivity() {

    private var data = ArrayList<RetrofitUserListModelClass.Data>()
    private lateinit var recyclerView: RecyclerView
    lateinit var adapter: RetrofitUserListAdapter
    private lateinit var userName: EditText
    private lateinit var userJob: EditText
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_user_data)

        recyclerView = findViewById(R.id.recyclerView)
        val btnAdd: FloatingActionButton = findViewById(R.id.btnAdd)
        progressBar = findViewById(R.id.progressBar)

        btnAdd.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.add_user_dialog)
            val dialogAttributes = WindowManager.LayoutParams()
            dialogAttributes.width = WindowManager.LayoutParams.MATCH_PARENT
            dialogAttributes.height = WindowManager.LayoutParams.WRAP_CONTENT
            dialog.window?.attributes = dialogAttributes

            userName = dialog.findViewById(R.id.etName)
            userJob = dialog.findViewById(R.id.etJob)
            val btnSubmit = dialog.findViewById<Button>(R.id.btnSubmit)

            btnSubmit.setOnClickListener {
                callAddSUser()
                dialog.dismiss()
            }
            dialog.show()
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RetrofitUserListAdapter(data, this)
        recyclerView.adapter = adapter
        progressBar.visibility = View.VISIBLE
        callRecyclerView()
    }

    private fun callRecyclerView() {
        val apiInterface = ApiInterface.getRetrofitObject().create(ApiInterface::class.java)
        val loginAPI = apiInterface.getUserList()
        loginAPI.enqueue(object : Callback<RetrofitUserListModelClass> {
            override fun onResponse(
                call: Call<RetrofitUserListModelClass>,
                response: Response<RetrofitUserListModelClass>
            ) {
                val responseBody = response.body()?.data
                data = responseBody as ArrayList<RetrofitUserListModelClass.Data>
                adapter = RetrofitUserListAdapter(data, this@RetrofitUserDataActivity)
                recyclerView.adapter = adapter
                progressBar.visibility = View.INVISIBLE
            }

            override fun onFailure(call: Call<RetrofitUserListModelClass>, t: Throwable) {
            }
        })
    }

    private fun callAddSUser() {
        val apiInterface = ApiInterface.getRetrofitObject().create(ApiInterface::class.java)
        val loginRequest = AddUserDataClass()
        loginRequest.name = userName.text.toString()
        loginRequest.job = userJob.text.toString()
        val loginAPI = apiInterface.addUser(loginRequest)
        loginAPI.enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                val body: Any? = response.body()
                Toast.makeText(this@RetrofitUserDataActivity, body.toString(), Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
            }
        })
    }
}
