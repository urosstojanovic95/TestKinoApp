package com.example.testkinoapp.services


import com.example.testkinoapp.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.ResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal object Api {

    val client: HttpClient by lazy {
        HttpClient(OkHttp) {
            expectSuccess = true

            HttpResponseValidator {
                handleResponseExceptionWithRequest { exception, _ ->
                    if (exception is ResponseException) {
                        throw Exception(exception.response.bodyAsText())
                    }
                    return@handleResponseExceptionWithRequest
                }
            }

            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                    }
                )
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        println("Ktor logger: $message")
                    }
                }
                level = LogLevel.ALL
            }

            defaultRequest {
                host = BuildConfig.BASE_URL
                url {
                    protocol = URLProtocol.HTTPS
                }
                header(
                    HttpHeaders.ContentType, ContentType.Application.Json
                )
            }


        }
    }
}

