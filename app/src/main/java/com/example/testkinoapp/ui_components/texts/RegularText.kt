package com.example.testkinoapp.ui_components.texts

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.testkinoapp.R

@Composable
fun RegularText(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = colorResource(id = R.color.textColor),
    fontSize: Int = R.dimen.mediumText
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = TextStyle(
            fontSize = dimensionResource(id = fontSize).value.sp,
            color = color,
        )
    )
}