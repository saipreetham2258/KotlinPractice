package com.example.plugins

import com.example.routes.CustomerRoute
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        CustomerRoute()
    }
}
