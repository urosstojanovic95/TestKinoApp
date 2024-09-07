package com.example.testkinoapp.ui_components.images

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.testkinoapp.R
import androidx.compose.foundation.Image

@Composable
fun Icon(
    iconId: Int,
    wrapContent: Alignment = Alignment.Center
) {
    Image(
        modifier = Modifier
            .wrapContentSize(wrapContent),
        painter = painterResource(id = iconId),
        contentScale = ContentScale.Fit,
        contentDescription = stringResource(id = R.string.flag)
    )
}