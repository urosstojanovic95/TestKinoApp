package com.example.testkinoapp.screens.draw

import androidx.compose.runtime.mutableStateOf
import com.example.testkinoapp.BaseViewModel
import com.example.testkinoapp.model.Draw
import kotlinx.coroutines.launch

class DrawViewModel : BaseViewModel() {

    var draws = mutableStateOf(listOf<Draw>())
        private set

    fun getDraws() {
        loading.value = true
        coroutineScope.launch {
            draws.value = drawRepository.getDraws(20)
            loading.value = false
        }
    }

    fun removeDraw(draw: Draw) {
        draws.value = draws.value.toMutableList().apply { remove(draw) }
        if (draws.value.size < 19) {
            getDraws()
        }
    }


}
