package com.example.testkinoapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.testkinoapp.model.Draw
import com.example.testkinoapp.repository.DrawRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

abstract class BaseViewModel : ViewModel() {

    val drawRepository: DrawRepository = DrawRepository
    var loading = mutableStateOf(false)

    private val exceptionHandler =
        CoroutineExceptionHandler { _, exception ->
            exception.printStackTrace()
            loading.value = false
        }
    protected val coroutineScope =
        CoroutineScope(Dispatchers.IO + SupervisorJob() + exceptionHandler)

}