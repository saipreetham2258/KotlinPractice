package com.example

import com.example.customer.module.CustomerDetails
import com.example.customer.module.DataBaseConnection
import com.example.plugins.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.litote.kmongo.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSecurity()
    configureSerialization()
    configureRouting()
    var collect = DataBaseConnection.dbConnection()


    routing {
       post("/customer") {
            //Receive and deserialize the incoming JSON to a CustomerDetails object
           val customer   = call.receive<CustomerDetails>()
            //Insert the customer into the collection
           val result = collect.insertOne(customer)
//            //Get the inserted ID as an Int
//           val insertedId = result.insertedId?.asString()?.value
//            //Convert the customerId to String? to String
//           val idString : String = insertedId.toString()
//            //Respond with the created customer and its ID
//           call.respond(HttpStatusCode.Accepted,customer.copy(id = idString))
//            //this will add parameter id to idString
           call.respond(HttpStatusCode.Created,"Data inserted successfully")

       }
       get("/{id?}") {
           val id = call.parameters["id"]

           val customers = collect.findOne(CustomerDetails::id eq id)
           if (customers != null) {
               call.respond(customers)
           } else {
               call.respondText("Not found user", status = HttpStatusCode.NotFound)
           }

       }

        get("/all") {
            val cus = collect.find().toList()
            call.respond(cus)
        }

        delete("/delete/{id}") {
            val id = call.parameters["id"]
            if(id != null) {
                val res = collect.deleteOne(CustomerDetails::id eq id)
                if(res.deletedCount > 0) {
                    call.respond(HttpStatusCode.Accepted,"Data deleted")
                }
                else {
                    call.respond(HttpStatusCode.NotFound,"Not found customer with this $id")
                }
            }
        }

        put("/{id?}") {
            val id = call.parameters["id"]
            val equal = collect.findOne(CustomerDetails::id eq id)
            if(equal != null) {
                val updated = call.receive<CustomerDetails>()
                val result = collect.updateOne(CustomerDetails::id eq id,
                    combine(setValue(CustomerDetails::id , updated.id),
                            setValue(CustomerDetails::name, updated.name),
                            setValue(CustomerDetails::product_purchased, updated.product_purchased),
                            setValue(CustomerDetails::price, updated.price)
                    )

                )
                if(result.matchedCount == 0L) {
                    call.respond(HttpStatusCode.OK,"not updated")
                }
                else {
                   call.respondText("Sucessfully updated", status = HttpStatusCode.OK)
                }

            }
            else {
                call.respond(HttpStatusCode.NotFound,"Not found user")
            }
        }
        get("/header") {
            call.response.headers.append("format","application/json")
            call.respondText("successfully added", status = HttpStatusCode.OK)
        }
        get("/submit") {
            val headervalue = call.request.headers["Custom-Header"]
            call.respondText("receivedheader : $headervalue", status = HttpStatusCode.Created)
        }





    }
}
