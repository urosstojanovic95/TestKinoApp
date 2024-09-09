package com.example.testkinoapp.screens.results

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testkinoapp.ui_components.grids.ResultsGrid

@Composable
fun ResultsScreen() {

    val viewModel: ResultsViewModel = viewModel()
    LaunchedEffect(Unit) {
        viewModel.getResults()
    }
    ResultsGrid(items = viewModel.results.value)
}