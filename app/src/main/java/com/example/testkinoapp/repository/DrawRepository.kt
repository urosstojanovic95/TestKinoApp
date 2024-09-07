package com.example.testkinoapp.repository

import com.example.testkinoapp.model.Draw
import com.example.testkinoapp.services.Api
import com.example.testkinoapp.utils.Constants
import io.ktor.client.call.body
import io.ktor.client.request.get

object DrawRepository {

    suspend fun getDraws(limit: Int): List<Draw> {
        return Api.client.get(Endpoints.Default.draws + Endpoints.Default.apiV3 + "/" + Constants.GREEK_KINO_ID + Endpoints.Default.upcoming + "/$limit") {
        }.body()
    }

    suspend fun getDraw(drawId: Long): Draw {
        return Api.client.get(Endpoints.Default.draws + Endpoints.Default.apiV3 + "/" + Constants.GREEK_KINO_ID + "/$drawId") {
        }.body()
    }
}