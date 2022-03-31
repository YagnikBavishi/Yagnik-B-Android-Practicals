package com.example.androidpractical.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractical.Models.UserListModelClass
import com.example.androidpractical.R
import com.example.androidpractical.adapter.UserListAdapter
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class UserListWithAPICallActivity : AppCompatActivity() {

    private val data = ArrayList<UserListModelClass>()
    private var response = StringBuffer()
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list_api_calling)

        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)
        recyclerView.layoutManager = LinearLayoutManager(this)

        var adapter = UserListAdapter(data)
        recyclerView.adapter = adapter
        progressBar.visibility = View.VISIBLE

        Thread {
            try {
                getWebServiceResponseData()
                runOnUiThread {
                    adapter = UserListAdapter(data)
                    recyclerView.adapter = adapter
                    progressBar.visibility = View.INVISIBLE
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }.start()
    }

    private fun getWebServiceResponseData(): Void? {
        try {
            val url = URL(getString(R.string.delay_url))
            val connection = url.openConnection() as HttpURLConnection
            connection.setRequestProperty(
                getString(R.string.content_type),
                getString(R.string.application_json)
            )
            connection.requestMethod = getString(R.string.get_method)
            val responseCode = connection.responseCode
            if (responseCode == HttpsURLConnection.HTTP_OK) {
                val input = BufferedReader(
                    InputStreamReader(connection.inputStream)
                )
                var output: String?
                response = StringBuffer()
                while (input.readLine().also { output = it } != null) {
                    response.append(output)
                }
                input.close()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val responseText: String = response.toString()
        try {
            val jsonObject = JSONObject(responseText)
            val jsonArray = jsonObject.getJSONArray(getString(R.string.data))

            for (index in 0 until jsonArray.length()) {
                data.add(
                    UserListModelClass(
                        jsonArray.getJSONObject(index).getString(getString(R.string.avatar)),
                        jsonArray.getJSONObject(index).getString(getString(R.string.user_email)),
                        jsonArray.getJSONObject(index)
                            .getString(getString(R.string.user_first_name))
                    )
                )
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return null
    }
}