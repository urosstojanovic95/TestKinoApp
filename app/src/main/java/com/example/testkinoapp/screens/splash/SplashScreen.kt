package com.example.testkinoapp.screens.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.testkinoapp.ui_components.images.Background
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    LaunchedEffect(key1 = true) {
        delay(2000)
        onTimeout()
    }
    Background()
}
