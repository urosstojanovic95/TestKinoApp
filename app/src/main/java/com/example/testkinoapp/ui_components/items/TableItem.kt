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
    number: Int,
    onItemClick: () -> Unit = {},
    addingEnabled: Boolean = true,
    preSelected: Boolean = false,
) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(40.dp)
            .clip(CircleShape)
            .tableItemBackground(preSelected, number)
            .clickable {
                if (preSelected|| addingEnabled) {
                    onItemClick()
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = number.toString(),
            color = if (preSelected) Color.Black else colorResource(id = R.color.textColor),
        )
    }
}