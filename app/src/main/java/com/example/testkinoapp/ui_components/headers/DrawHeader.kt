package com.example.testkinoapp.ui_components.headers

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testkinoapp.R
import com.example.testkinoapp.ui_components.images.Icon
import com.example.testkinoapp.ui_components.texts.TitleText

@Preview
@Composable
fun DrawHeader(
    modifier: Modifier = Modifier,
    drawCount: Int = 20,
    drawMax: Int? = 80,
    title: String = stringResource(id = R.string.grcki_kino),
    icon: Int = R.drawable.ic_greece_flag,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable(interactionSource = remember {
                MutableInteractionSource()
            }, indication = null, onClick = onClick)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(icon)
            Spacer(modifier = Modifier.width(10.dp))
            TitleText(text = "$title ($drawCount/$drawMax)")
        }
    }
}