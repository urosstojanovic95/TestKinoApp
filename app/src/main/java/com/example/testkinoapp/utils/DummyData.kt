package com.example.testkinoapp.utils

import com.example.testkinoapp.model.Draw
import com.example.testkinoapp.model.Result

object DummyData {

    val result = Result(
        gameId = 12345,
        drawId = 54321,
        drawTime = 1602580200000,
        status = "ACTIVE",
        drawBreak = 5,
        visualDraw = 65432,
        winningNumbers = Result.WinningNumbers(
            list = mutableListOf(5, 12, 13, 165, 11, 111, 23, 34, 45, 42, 80, 78, 76, 56)
        )
    )
    val results = listOf(result, result, result, result, result)

    val draw = Draw(
        drawId = 21321,
        gameId = 1100,
        drawTime = 1602580200000,
        status = Constants.DrawStatus.ACTIVE.value
    )

    val draws = listOf(
        Draw(
            drawId = 21341,
            gameId = 1100,
            drawTime = 1602580200000,
            status = Constants.DrawStatus.ACTIVE.value
        ),
        Draw(
            drawId = 21325,
            gameId = 1100,
            drawTime = 1602580200000,
            status = Constants.DrawStatus.ACTIVE.value
        ),
        Draw(
            drawId = 21621,
            gameId = 1100,
            drawTime = 1602580200000,
            status = Constants.DrawStatus.ACTIVE.value
        ),
        Draw(
            drawId = 21721,
            gameId = 1100,
            drawTime = 1602580203230,
            status = Constants.DrawStatus.ACTIVE.value
        ),
        Draw(
            drawId = 21331,
            gameId = 1100,
            drawTime = 1602580200000,
            status = Constants.DrawStatus.ACTIVE.value
        ),
        Draw(
            drawId = 21361,
            gameId = 1100,
            drawTime = 1602580200000,
            status = Constants.DrawStatus.ACTIVE.value
        ),
        Draw(
            drawId = 21821,
            gameId = 1100,
            drawTime = 1602580200000,
            status = Constants.DrawStatus.ACTIVE.value
        ),
        Draw(
            drawId = 21391,
            gameId = 1100,
            drawTime = 1602580200000,
            status = Constants.DrawStatus.ACTIVE.value
        ),
        Draw(
            drawId = 213292,
            gameId = 1100,
            drawTime = 1602580200000,
            status = Constants.DrawStatus.ACTIVE.value
        )
    )
}