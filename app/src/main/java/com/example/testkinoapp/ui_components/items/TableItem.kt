package com.example.testkinoapp.ui_components.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.testkinoapp.R
import com.example.testkinoapp.extensions.tableItemBackground

@Composable
fun TableItem(
    index: Int,
    onItemClick: () -> Unit = {},
    addingEnabled: Boolean = true
) {
    val selected = remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(40.dp)
            .clip(CircleShape)
            .tableItemBackground(selected.value, index)
            .clickable {
                if (selected.value || addingEnabled) {
                    selected.value = !selected.value
                    onItemClick()
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = index.toString(),
            color = if (selected.value) Color.Black else colorResource(id = R.color.textColor),
        )
    }
}