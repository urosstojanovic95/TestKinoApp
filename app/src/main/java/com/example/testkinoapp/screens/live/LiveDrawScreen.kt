package com.example.testkinoapp.screens.live

import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.testkinoapp.model.Draw
import com.example.testkinoapp.utils.Constants

@Composable
fun LiveDrawScreen() {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { ctx ->
            WebView(ctx).apply {
                webViewClient = object : WebViewClient() {
                    override fun onPageFinished(view: WebView?, url: String?) {
                        super.onPageFinished(view, url)
                        if (view?.getProgress() == 100) {
                        }
                    }

                    override fun onReceivedError(
                        view: WebView?,
                        request: WebResourceRequest?,
                        error: WebResourceError?
                    ) {
                        super.onReceivedError(view, request, error)
                    }
                }
                settings.apply {
                    builtInZoomControls = true
                    displayZoomControls = false
                    javaScriptEnabled = true
                    domStorageEnabled = true
                }
                loadUrl(Constants.LIVE_URL)
            }
        },
        update = { webView ->
            webView.loadUrl(Constants.LIVE_URL)
        }
    )
}

