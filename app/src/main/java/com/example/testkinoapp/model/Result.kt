package com.example.testkinoapp.model

import com.example.testkinoapp.utils.Constants.DEFAULT_DATE_FORMAT
import com.example.testkinoapp.utils.Tools
import kotlinx.serialization.Serializable
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

@Serializable
data class Result(
    val gameId: Long? = null,
    val drawId: Long? = null,
    val drawTime: Long? = null,
    val status: String? = null,
    val drawBreak: Int? = null,
    val visualDraw: Long? = null,
    val winningNumbers: WinningNumbers? = null
) {


    val time: String
        get() = Tools.formatTimestamp(drawTime ?: 0, DEFAULT_DATE_FORMAT)


    @Serializable
    data class WinningNumbers(
        val list: MutableList<Int>
    )
}
