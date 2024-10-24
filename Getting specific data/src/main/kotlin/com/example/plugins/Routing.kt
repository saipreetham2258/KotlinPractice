package com.example.plugins

import com.example.model.Customer
import com.example.model.Priority
import com.example.model.list
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {

        get("/user") {
            call.respond(list)
        }

        get("/{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText("Not found id", status = HttpStatusCode.NotFound)
            val result = list.find { it.id == id } ?: return@get call.respondText("Not found costumer", status = HttpStatusCode.NotFound)
            call.respond(result)
        }


    }
}
