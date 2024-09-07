package com.example.testkinoapp.ui_components.grids

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testkinoapp.ui_components.items.TableItem

@Preview
@Composable
fun TableGrid(
    onItemClick: (Int) -> Unit = {},
    addingEnabled: Boolean = true,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(8),
        contentPadding = PaddingValues(8.dp),
    ) {
        items(80) { index ->
            TableItem(index = index + 1,
                onItemClick = { onItemClick(index + 1) },
                addingEnabled =addingEnabled
            )
        }
    }
}