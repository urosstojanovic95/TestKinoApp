package com.example.testkinoapp.extensions

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


fun Modifier.tableItemBackground(selected: Boolean, index: Int): Modifier {
    val borderColor = when (index) {
        in 1..8 -> Color.Red
        in 9..16 -> Color.Blue
        in 17..24 -> Color.Green
        in 25..32 -> Color.Yellow
        in 33..40 -> Color.Cyan
        in 41..48 -> Color.Magenta
        in 49..56 -> Color.Blue
        in 57..64 -> Color.Cyan
        in 65..72 -> Color.Red
        in 73..80 -> Color.Yellow
        else -> Color.Transparent
    }
    return this
        .background(if (selected) Color.White else Color.Gray.copy(alpha = 0.3f))
        .border(2.dp, if (selected) borderColor else Color.LightGray, CircleShape)
}