package com.example.testkinoapp.screens.live

import android.webkit.WebChromeClient
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.viewinterop.AndroidView
import com.example.testkinoapp.R
import com.example.testkinoapp.ui_components.loaders.Loader
import com.example.testkinoapp.utils.Constants
import com.example.testkinoapp.utils.Tools

@Composable
fun LiveDrawScreen() {
    val showContent = remember {
        mutableStateOf(false)
    }


    AndroidView(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.backgroundColor)),
        factory = { ctx ->
            WebView(ctx).apply {
                WebView.setWebContentsDebuggingEnabled(true)
                background = AppCompatResources.getDrawable(ctx, R.color.backgroundColor)
                webViewClient = object : WebViewClient() {
                    override fun shouldOverrideUrlLoading(
                        view: WebView?,
                        request: WebResourceRequest?
                    ): Boolean {
                        return false
                    }

                    override fun onLoadResource(view: WebView?, url: String?) {
                        super.onLoadResource(view, url)
                    }

                    override fun onPageFinished(view: WebView?, url: String?) {
                        super.onPageFinished(view, url)
                        showContent.value = true
                    }

                    override fun onReceivedError(
                        view: WebView?,
                        request: WebResourceRequest?,
                        error: WebResourceError?
                    ) {
                        super.onReceivedError(view, request, error)
                    }
                }

                webChromeClient = object : WebChromeClient() {
                    override fun onProgressChanged(view: WebView?, newProgress: Int) {
                        super.onProgressChanged(view, newProgress)
                        if (newProgress == 100) {
                            showContent.value = true
                        }
                    }
                }

                settings.apply {
                    builtInZoomControls = true
                    displayZoomControls = false
                    javaScriptEnabled = true
                    domStorageEnabled = true
                    cacheMode = WebSettings.LOAD_NO_CACHE
                    mixedContentMode = WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE
                }

                clearCache(true)
                clearHistory()
                loadUrl(Constants.LIVE_URL)
            }
        }
    )

    AnimatedVisibility(
        visible = !showContent.value,
        exit = fadeOut()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.backgroundColor))
        ) {

            Loader()
        }
    }
}
