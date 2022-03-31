package com.example.androidpractical.activities

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import com.example.androidpractical.`interface`.ApiInterface
import com.example.androidpractical.Models.SingleUserDataClass
import com.example.androidpractical.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executors

class DisplaySingleUserDataActivity : AppCompatActivity() {

    private lateinit var singleUser: SingleUserDataClass
    lateinit var imgView: ImageView
    private lateinit var tvId: TextView
    private lateinit var tvFirstName: TextView
    private lateinit var tvLastName: TextView
    private lateinit var tvEmail: TextView
    private var id = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_single_user_data)

        tvId = findViewById(R.id.tvUserId)
        tvFirstName = findViewById(R.id.tvFirstName)
        tvEmail = findViewById(R.id.tvEmail)
        tvLastName = findViewById(R.id.tvLastName)
        imgView = findViewById(R.id.imageView)

        imgView.clipToOutline = true
        val intent = intent
        id = intent.getStringExtra(getString(R.string.user_id)).toString()
        tvId.text = id
        callSingleUserData()
    }

    private fun callSingleUserData() {
        val apiInterface = ApiInterface.getRetrofitObject().create(ApiInterface::class.java)
        val loginAPI = apiInterface.getSingleUser(id)
        loginAPI.enqueue(object : Callback<SingleUserDataClass> {
            override fun onResponse(
                call: Call<SingleUserDataClass>,
                response: Response<SingleUserDataClass>
            ) {
                val responseBody = response.body()
                if (responseBody != null) {
                    singleUser = responseBody
                }
                tvId.text = singleUser.data.id.toString()
                tvEmail.text = singleUser.data.email
                tvFirstName.text = singleUser.data.firstName
                tvLastName.text = singleUser.data.lastName
                val url = singleUser.data.avatar
                val executor = Executors.newSingleThreadExecutor()
                val handler = Handler(Looper.getMainLooper())
                var image: Bitmap?
                executor.execute {
                    try {
                        val userImage = java.net.URL(url).openStream()
                        image = BitmapFactory.decodeStream(userImage)

                        handler.post {
                            imgView.setImageBitmap(image)
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<SingleUserDataClass>, t: Throwable) {
            }
        })
    }
}