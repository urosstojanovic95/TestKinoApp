package com.example.testkinoapp.model

import kotlinx.serialization.Serializable
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

@Serializable
data class Draw(
    val gameId: Long? = null,
    val drawId: Long? = null,
    val drawTime: Long? = null,
    val status: String? = null
) {
    val time: ZonedDateTime
        get() = Instant.ofEpochMilli(drawTime ?: 0).atZone(ZoneId.systemDefault())
    val hourAndMinute: String
        get() = String.format("%02d:%02d", time.hour, time.minute)
}

