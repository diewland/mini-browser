package com.diewland.webviewdemo

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.TextView
import androidx.browser.customtabs.CustomTabsIntent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // prepare url, buttons
        val tv_url = findViewById<TextView>(R.id.tv_url)
        val btn_wv = findViewById<Button>(R.id.btn_wv)
        val btn_ct = findViewById<Button>(R.id.btn_ct)

        // prepare webview
        var wv = findViewById<WebView>(R.id.wv)
        wv.webViewClient = WebViewClient()
        wv.settings.javaScriptEnabled = true

        // bind WebView
        btn_wv.setOnClickListener {
            val url = tv_url.getText().toString()
            wv!!.loadUrl(url)
        }

        // bind CustomTabs
        btn_ct.setOnClickListener {
            val url = tv_url.getText().toString()
            val builder = CustomTabsIntent.Builder()
            val customTabsIntent = builder.build()
            customTabsIntent.launchUrl(this, Uri.parse(url))
        }
    }
}
