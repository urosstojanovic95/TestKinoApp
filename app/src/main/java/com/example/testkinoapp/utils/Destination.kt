package com.example.testkinoapp.utils

import com.example.testkinoapp.R

object Destination {

    const val DrawScreen = "drawScreen"
    const val TableScreen = "tableScreen"
    const val ResultsScreen = "resultsScreen"
    const val LiveDraw = "liveDrawScreen"
    const val DrawIdParam = "drawId"

    sealed class BottomNavigationScreens(
        val route: String,
        val labelId: Int,
        val iconId: Int,
    ) {
        data object Draw : BottomNavigationScreens(
            Destination.DrawScreen,
            R.string.brze_igre,
            R.drawable.ic_squares,
        )
        data object LiveDraw : BottomNavigationScreens(
            Destination.LiveDraw,
            R.string.izvlacenje,
            R.drawable.ic_play_circle,
        )

        data object Results : BottomNavigationScreens(
            Destination.ResultsScreen,
            R.string.rezultati,
            R.drawable.ic_result,
        )
    }

}