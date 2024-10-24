package com.example.plugins

import com.auth0.jwt.JWT
import com.example.module.*
import com.typesafe.config.ConfigFactory
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.config.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.bson.Document
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.findOneById
import org.litote.kmongo.setValue
import redis.clients.jedis.Jedis
import java.util.*
import kotlin.math.exp

fun Application.configureRouting() {
    val tokenObject = TokenManager(HoconApplicationConfig(ConfigFactory.load()))
    routing {
        get{
            val id = call.request.headers["id"]
            val data = getById(id?.toInt())
            data?.let {
                call.respond(HttpStatusCode.OK,data)
            } ?: return@get call.respond(HttpStatusCode.NotFound,"user not found of id : $id")
        }

        post("/add-user") {
            val data = call.receive<UserData>()
            val response = addUser(data)
            if(response) {
                call.respond(HttpStatusCode.OK,"User added successfully")
            }
            else {
                call.respond(HttpStatusCode.OK,"Already user exist")
            }
        }

        delete {
            val id = call.request.headers["id"]?.toInt()
            if(deleteUser(id)) {
                call.respond(HttpStatusCode.OK,"User deleted of id : $id")
            }
            else {
                call.respond(HttpStatusCode.NotFound,"User not found of id : $id")
            }
        }

        get("/login") {
            val username = call.request.headers["username"]
            val password = call.request.headers["password"]

            var user = DataBaseConnection.getDbCollection().findOne(UserData::username eq username)
            if(user != null) {
                if(user.password.equals(password)) {
                    val token = tokenObject.generateToken(user.username)
//                    DataBaseConnection.getDbCollection().updateOne(UserData::username eq username, setValue(UserData::token,token))
                    call.respond(HttpStatusCode.OK, mapOf("token" to token))
                }
                else {
                    call.respond(HttpStatusCode.BadRequest,"Password is invalid")
                }

            }
            else {
                call.respond(HttpStatusCode.NotFound,"User not found of this username : $username")
            }

        }

       get("/{id?}") {
           val id = call.parameters["id"]?.toInt()
            val user = DataBaseConnection.getDbCollection().findOne(UserData::id eq id)
           if(user != null) {
               val getToken = user.token
               val decodedToken = JWT.decode(getToken) //To decode token
               val expires = decodedToken.expiresAt

               if(expires > Date(System.currentTimeMillis()))
               {
                   call.respond(HttpStatusCode.OK,"Token not expired")
               }
               else {
                   val token = tokenObject.generateToken(user.username)
                   call.respond(HttpStatusCode.OK,"Token expired and created again")
               }
           }

       }
        get("/redis") {
            val jedis = Jedis("localhost",6379)
//            jedis.set("name","Sai preetham reddy")
//            jedis.expire("name",60)
            val res = jedis.ttl("name")
            val result = jedis.get("name")
            call.respond(HttpStatusCode.OK,"remaining time : $result")
        }



    }
}
