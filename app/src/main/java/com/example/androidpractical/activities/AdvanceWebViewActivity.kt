package com.example.androidpractical.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.widget.SearchView
import com.example.androidpractical.R

class AdvanceWebViewActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advance_web_view)

        webView = findViewById(R.id.advanceWebView)
        val searchView: SearchView = findViewById(R.id.searchViewForWebView)

        searchView.queryHint = getString(R.string.search)
        val btnLoadPdf: Button = findViewById(R.id.btnLoadPdf)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                webView.loadUrl(getString(R.string.google_query_string) + query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })

        webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled
            loadUrl(getString(R.string.url))
        }

        btnLoadPdf.setOnClickListener {
            webView.settings.javaScriptEnabled = true
            webView.loadUrl(getString(R.string.embedded_string) + getString(R.string.pdf_link))
        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack())
            webView.goBack()
        else
            super.onBackPressed()
    }
}