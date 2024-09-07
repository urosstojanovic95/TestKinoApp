package com.example.testkinoapp.ui_components.headers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testkinoapp.R

@Composable
fun MainHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.mainHeaderHeight).value.dp)
            .background(color = colorResource(id = R.color.colorPrimary))
    ) {
        Image(
            modifier = Modifier.align(Alignment.CenterStart),
            painter = painterResource(id = R.drawable.ic_splash_logo),
            contentDescription = stringResource(id = R.string.splash_logo_description),
            contentScale = ContentScale.Fit
        )
    }
}