package com.example.testkinoapp.ui_components.custom

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.testkinoapp.R

@Composable
fun MainTheme(
    content: @Composable () -> Unit
) {
    val color = lightColorScheme(
        primary = colorResource(id = R.color.colorPrimary),
        onPrimary = colorResource(id = R.color.textColor),
        secondary = colorResource(id = R.color.colorSecondary),
        onSecondary = colorResource(id = R.color.textColor),
        background = colorResource(id = R.color.backgroundColor)
    )
    MaterialTheme(
        colorScheme = color,
        content = content
    )
}


