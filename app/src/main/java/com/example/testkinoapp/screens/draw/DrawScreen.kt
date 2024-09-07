package com.example.testkinoapp.screens.draw

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testkinoapp.model.Draw
import com.example.testkinoapp.ui_components.grids.DrawGrid
import com.example.testkinoapp.ui_components.headers.DrawHeader
import com.example.testkinoapp.ui_components.loaders.Loader

@Preview
@Composable
fun DrawScreen(
    onItemClick: (Draw) -> Unit = {}
) {
//    MainTheme() {
        val viewModel: DrawViewModel = viewModel()

        LaunchedEffect(Unit) {
            viewModel.getDraws()
        }
        var expandedHeader by remember { mutableStateOf(true) }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 10.dp)
        ) {
            item {
                DrawHeader(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    drawCount = viewModel.draws.value.size,
                    onClick = { expandedHeader = !expandedHeader }
                )
                AnimatedVisibility(
                    visible = expandedHeader,
                    enter = fadeIn(animationSpec = tween(300)) + expandVertically(tween(300)),
                    exit = fadeOut(animationSpec = tween(300)) + shrinkVertically(tween(300))
                ) {
                    DrawGrid(
                        items = viewModel.draws.value,
                        removeItem = viewModel::removeDraw,
                        onItemClick = onItemClick
                    )
                }
            }
        }
        if (viewModel.loading.value) {
            Loader()
        }
//    }

}

