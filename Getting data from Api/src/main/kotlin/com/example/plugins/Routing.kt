package com.example.plugins

import com.example.module.DataBaseConnectivity
import com.example.module.UserDetails
import com.example.module.client
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.json

fun Application.configureRouting() {
    routing {
        get("/user") {
            try{
               val resp = client.get("http://127.0.0.1:8081/all")
                val string = resp.bodyAsText()
                val json = Json.parseToJsonElement(string)
//                val result = Json.decodeFromString<UserDetails>(string)

//                val collect = DataBaseConnectivity.dataBaseConnectivity()
//                val insertdata = collect.insertOne(result)
                call.respond(HttpStatusCode.OK,json)
            }
            catch (e : Exception) {
                call.respond(HttpStatusCode.InternalServerError,"${e.message}")

            }


        }
        get("{id?}") {
            val id = call.parameters["id"]
            if(id != null) {
                val id1 = id.toInt()
                val customer = DataBaseConnectivity.dataBaseConnectivity().findOne(UserDetails::id eq id1)
                if(customer != null) {
                    call.respond(HttpStatusCode.OK, customer)
                }
                else {
                    call.respond(HttpStatusCode.NotFound, "No user found")
                }
            }
        }
    }
}
