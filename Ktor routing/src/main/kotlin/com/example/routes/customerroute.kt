package com.example.routes

import com.example.customermodules.Customer
import com.example.customermodules.UserList
//import com.example.customermodules.customers
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.CustomerRoute() {
        get("/all") {
            val obj1 = mutableListOf(UserList("sai","20000","suryapet"))
            val obj = Customer("101","sai",22,"sai@123",obj1)
            val list2 = mutableListOf(obj)
            try {
                call.respond(HttpStatusCode.OK,list2)
            }
            catch (e : Exception) {
                call.respond(HttpStatusCode.NotFound,"message : ${e.message}")
            }

        }
    }