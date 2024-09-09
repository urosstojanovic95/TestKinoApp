package com.example.testkinoapp.ui_components.grids

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.testkinoapp.R
import com.example.testkinoapp.model.Result
import com.example.testkinoapp.screens.draw.DrawScreen
import com.example.testkinoapp.ui_components.items.DrawItem
import com.example.testkinoapp.ui_components.items.ResultItem
import com.example.testkinoapp.utils.DummyData

@Composable
fun ResultsGrid(
    items: List<Result>
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items.size) { index ->
            ResultItem(
                items[index]
            )
        }
    }
}

@Preview
@Composable
fun ResultsGridPreview(
) {
    ResultsGrid(items = DummyData.results)
}

