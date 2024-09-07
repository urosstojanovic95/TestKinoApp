package com.example.testkinoapp.screens.table

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import com.example.testkinoapp.BaseViewModel
import com.example.testkinoapp.model.Draw
import com.example.testkinoapp.utils.Constants
import com.example.testkinoapp.utils.Tools
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class TableViewModel : BaseViewModel() {
    var selectedNumbers = mutableStateOf(listOf<Int>())
    var draw = mutableStateOf(Draw())
        private set
    var eventFlow = MutableSharedFlow<Unit>()
        private set

    val addingEnabled: Boolean
        get() = selectedNumbers.value.size < Constants.MAX_NUMBERS

    fun getDraw(drawId: Long) {
        loading.value = true
        coroutineScope.launch {
            draw.value = drawRepository.getDraw(drawId)
            eventFlow.emit(Unit)
            loading.value = false
        }
    }

    fun onItemClick(number: Int) {

        selectedNumbers.value = selectedNumbers.value.toMutableList().apply {
            if (selectedNumbers.value.contains(number)) {
                remove(number)
            } else {
                add(number)
            }
        }
        Tools.log("added numbers ${selectedNumbers.value.size}")
    }
}