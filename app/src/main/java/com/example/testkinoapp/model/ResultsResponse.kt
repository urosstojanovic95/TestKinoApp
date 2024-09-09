package com.example.testkinoapp.model

import kotlinx.serialization.Serializable


@Serializable
data class ResultsResponse(
    val content: MutableList<Result>
)