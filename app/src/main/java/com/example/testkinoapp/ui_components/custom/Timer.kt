package com.example.testkinoapp.ui_components.custom

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import kotlinx.coroutines.delay
import java.time.Duration
import java.time.Instant

@Composable
fun Timer(
    startTime: Instant,
    endTime: Instant,
    timeState: MutableState<String>,
    onTimeElapsed: () -> Unit
) {
    LaunchedEffect(Unit) {
        while (true) {
            val duration = Duration.between(startTime, endTime)
            if (duration.isNegative || duration.isZero) {
                timeState.value = "00:00"
                onTimeElapsed()
                break
            }
            val minutes = duration.toMinutes() % 60
            val seconds = duration.seconds % 60
            timeState.value = String.format("%02d:%02d", minutes, seconds)
            delay(1000)
        }
    }
}