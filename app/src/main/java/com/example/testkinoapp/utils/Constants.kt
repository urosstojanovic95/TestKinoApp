package com.example.testkinoapp.utils

object Constants {
    const val GREEK_KINO_ID: String = "1100"
    const val LIVE_URL: String = "https://mozzartbet.com/sr/lotto-animation/26#"
    const val MAX_NUMBERS: Int = 15
    const val DEFAULT_DATE_FORMAT: String = "yyyy-MM-dd HH:mm"
    enum class DrawStatus(val value: String) {
        ACTIVE("active"),
        FUTURE("future")
    }


    val FixMapping: Map<Int, String> = mapOf(
        1 to "3.75",
        2 to "14",
        3 to "65",
        4 to "275",
        5 to "1350",
        6 to "6500",
        7 to "25000",
        8 to "125000",
    )
}