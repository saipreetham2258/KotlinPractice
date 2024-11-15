package com.example.plugins

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.example.module.DataBaseConnectivity
import com.example.module.LoginData
import com.example.module.User
import com.typesafe.config.ConfigFactory
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.config.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import org.litote.kmongo.Data
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.mindrot.jbcrypt.BCrypt
import java.util.*


fun Application.configureRouting() {
    routing {
        post("/user") {
           var data = call.receive<LoginData>()
            val hashPassword = BCrypt.hashpw(data.password,BCrypt.gensalt())
            data = data.copy(password = hashPassword)
            DataBaseConnectivity.datBaseConnectivity().insertOne(data)
            call.respond(HttpStatusCode.OK,"uploaded")
        }
        get("/specific-user") {
            val data = call.request.queryParameters["name"]
            var result = DataBaseConnectivity.datBaseConnectivity().findOne(LoginData::userName eq data)
            val pass = BCrypt.hashpw(result?.password,BCrypt.gensalt())
            result = result?.copy(password = pass)
            if(result != null){
                call.respond(HttpStatusCode.OK,result)
            }
            else {
                call.respond(HttpStatusCode.NotFound,"No user found")
            }
        }
        get("/check-user") {
            var data = call.receive<LoginData>()
            if(data != null) {
                var find = DataBaseConnectivity.datBaseConnectivity().findOne(LoginData::userName eq data.userName)
                if(find != null) {
                    val check : Boolean = BCrypt.checkpw(data.password,find.password)
                    if(check == true) {
                        try{
                            val token = createToken(data.userName)
                            call.respond(HttpStatusCode.OK, mapOf("token" to token))
                        }
                        catch(e : Exception) {
                            call.respond(HttpStatusCode.InternalServerError,"${e.message}")
                        }

                    }
                    else {
                        call.respond(HttpStatusCode.NotFound,"Data not matched")
                    }
                }
                else {
                    call.respond(HttpStatusCode.NotFound,"No user found")
                }
            }
            else {
                call.respond(HttpStatusCode.BadRequest,"No data found")
            }
        }
        authenticate {
            get("/verified") {
                val user = call.principal<JWTPrincipal>()
                val username = user!!.payload.getClaim("username").asString()
            call.respond(HttpStatusCode.OK,"You are authenticated successfully $username")
            }
        }


    }
}

fun createToken(username : String) : String {
    val algorithm = Algorithm.HMAC256("Reddy@123")
    return JWT.create()
        .withSubject(username)
        .withIssuer("ktor.io")
        .withExpiresAt(Date(System.currentTimeMillis()+60000 ))
        .sign(algorithm)
}

fun makeJwtVerifier(): JWTVerifier {
    val algorithm = Algorithm.HMAC256("Reddy@123")
    return JWT.require(algorithm)
        .withIssuer("ktor.io")
        .build()

}
