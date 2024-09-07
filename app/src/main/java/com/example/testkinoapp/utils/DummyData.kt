package com.example.testkinoapp.utils

import com.example.testkinoapp.model.Draw

object DummyData {

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