package com.example.testkinoapp.ui_components.grids

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.testkinoapp.model.Draw
import com.example.testkinoapp.ui_components.items.DrawItem
import com.example.testkinoapp.utils.DummyData

@Preview
@Composable
fun DrawGrid(
    items: List<Draw> = DummyData.draws,
    removeItem: (Draw) -> Unit = {},
    onItemClick: (Draw) -> Unit = {}
) {

    Column(Modifier.animateContentSize()) {
        items.forEach { item ->
            DrawItem(
                item,
                onItemClick = {
                    onItemClick(item)
                },
                removeItem = {
                    removeItem(item)
                }
            )

        }
    }
}