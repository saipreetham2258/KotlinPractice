package com.example.Module

import com.example.plugins.configureRouting
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ApplicationTest {
//To test Apis without server to check the apis weather running properly or not
    @Test
    fun checkTest() {
        testApplication {
            application {
                configureRouting()
            }
        }

        val client = HttpClient(CIO)
        val response = runBlocking { client.get("http://127.0.0.1:8080/hello") }
        assertEquals(HttpStatusCode.OK,response.status)
        val responseBody = runBlocking{
            response.bodyAsText()
        }
        assertEquals("Hello",responseBody)
    }
}