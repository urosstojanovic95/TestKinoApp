package com.example.testkinoapp.ui_components.items

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testkinoapp.R
import com.example.testkinoapp.model.Draw
import com.example.testkinoapp.ui_components.texts.RegularText
import com.example.testkinoapp.utils.DummyData
import com.example.testkinoapp.utils.Tools
import kotlinx.coroutines.delay
import java.time.Duration
import java.time.Instant

@SuppressLint("DefaultLocale")
@Preview
@Composable
fun DrawItem(
    draw: Draw = DummyData.draw,
    removeItem: () -> Unit = {},
    onItemClick: () -> Unit = {}

) {

    var time = remember { mutableStateOf("00:00") }

    LaunchedEffect(Unit) {

        Tools.Timer(
            endTime = Instant.ofEpochMilli(draw.drawTime ?: 0),
            timeState = time,
            onTimeElapsed = {
                removeItem()
            }
        )
    }
    Column(
        modifier = Modifier.clickable(
            interactionSource = remember {
                MutableInteractionSource()
            },
            indication = null,
            onClick = onItemClick
        )
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            RegularText(text = stringResource(id = R.string.kolo_u) + " ${draw.hourAndMinute}")
            Spacer(modifier = Modifier.weight(1f))
            RegularText(text = time.value)
        }
        HorizontalDivider()
    }
}
