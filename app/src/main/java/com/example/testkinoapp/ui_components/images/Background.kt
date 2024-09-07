package com.example.testkinoapp.ui_components.images

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.testkinoapp.R

@Preview
@Composable
fun Background() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.colorPrimary))) {

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.ic_splash_logo),
            contentDescription = stringResource(id = R.string.splash_logo_description),
            contentScale = ContentScale.Fit
        )
    }

}