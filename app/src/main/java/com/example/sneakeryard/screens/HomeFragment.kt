package com.example.sneakeryard.screens

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.sneakeryard.R

class HomeFragment : Fragment() {

    private val url = "https://www.highsnobiety.com/sneakers/"
    var planWebView: WebView? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        planWebView = view.findViewById(R.id.websneakers) as WebView
        planWebView!!.loadUrl(url)

        val webSettings = this.planWebView!!.settings
        webSettings.javaScriptEnabled = true

        // Force links and redirects to open in the WebView instead of in a browser
        planWebView!!.webViewClient = WebViewClient()

        return view
    }
}