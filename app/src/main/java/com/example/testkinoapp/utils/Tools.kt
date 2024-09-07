package com.example.testkinoapp.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.MutableState
import com.example.testkinoapp.BuildConfig
import kotlinx.coroutines.delay
import java.time.Duration
import java.time.Instant

object Tools {

    suspend fun Timer(
        endTime: Instant,
        timeState: MutableState<String>,
        onTimeElapsed: () -> Unit
    ) {
        while (true) {
            val currentTime = Instant.now()
            val duration = Duration.between(currentTime, endTime)
            if (duration.isNegative || duration.isZero) {
                timeState.value = "00:00"
                onTimeElapsed()
                break
            }
            Tools.log("test timer start $currentTime")
            Tools.log("test timer end $endTime")
            val minutes = duration.toMinutes() % 60
            val seconds = duration.seconds % 60
            Tools.log("test timer minutes $seconds")
            timeState.value = String.format("%02d:%02d", minutes, seconds)
            delay(1000)
        }
    }

    fun log(msg: String?) {
        if (BuildConfig.DEBUG) {
            Log.d("test app: ", msg!!)
        }
    }

    fun showMsg(msg: String?, context: Context) {
        Toast.makeText(
            context,
            msg,
            Toast.LENGTH_LONG
        ).show()
    }

}