package com.example.Module.Exception

import com.fasterxml.jackson.databind.JsonMappingException
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import java.util.Date
import kotlinx.serialization.Serializable



@Serializable
private data class ApiResponse(val path : String,
                               val timeStamp : String,
                               val statusCode: String,
                               val message : String)

suspend fun ApplicationCall.fileResponseRequest(statusCode: HttpStatusCode,data: Any,mess : String) {
    respond(statusCode,
        ApiResponse(request.path(),Date(System.currentTimeMillis()).toString(),statusCode.toString(),mess)
    )
}
