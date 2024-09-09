package com.example.testkinoapp.screens.results

import androidx.compose.runtime.mutableStateOf
import com.example.testkinoapp.BaseViewModel
import com.example.testkinoapp.model.Draw
import com.example.testkinoapp.model.Result
import com.example.testkinoapp.utils.Tools
import kotlinx.coroutines.launch

class ResultsViewModel : BaseViewModel() {
    var results = mutableStateOf(listOf<Result>())
        private set

    fun getResults() {
        loading.value = true
        coroutineScope.launch {
            results.value = drawRepository.getResults(
                fromDate = Tools.getTodayDateRange(),
                endDate = Tools.getTodayDateRange()
            ).content
            loading.value = false
        }
    }
}