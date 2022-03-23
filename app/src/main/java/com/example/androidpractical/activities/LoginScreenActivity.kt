package com.example.androidpractical.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import com.example.androidpractical.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.*
import java.net.HttpURLConnection
import java.net.URL

class LoginScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        val tvEmail: EditText = findViewById(R.id.tfEmail)
        val tvPassWord: EditText = findViewById(R.id.tfPassword)
        val btnSubmit: Button = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            sendPostRequest(tvEmail.text.toString(), tvPassWord.text.toString())
        }
    }

    private fun sendPostRequest(email: String, password: String) {
        lifecycleScope.launch(Dispatchers.IO) {
            val credentials = JSONObject()
            credentials.put(getString(R.string.email), email)
            credentials.put(getString(R.string.password), password)
            val url = URL(getString(R.string.login_url))

            with(url.openConnection() as HttpURLConnection) {
                requestMethod = getString(R.string.post)
                setRequestProperty(
                    getString(R.string.content_type),
                    getString(R.string.application_json)
                )
                val writeStream = OutputStreamWriter(outputStream)
                writeStream.write(credentials.toString())
                writeStream.flush()
                withContext(Dispatchers.Main) {
                    val intent =
                        Intent(
                            this@LoginScreenActivity,
                            UserListWithAPICallActivity::class.java
                        )
                    startActivity(intent)
                }
            }
        }
    }
}