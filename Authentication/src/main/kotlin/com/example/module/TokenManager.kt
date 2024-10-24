package com.example.module

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.http.HttpHeaders.Date
import io.ktor.server.config.*
import org.litote.kmongo.eq
import org.litote.kmongo.json
import org.litote.kmongo.setValue
import java.util.*

class TokenManager(conf : HoconApplicationConfig) {
    val auidence = conf.property("jwt.audience").getString()
    val issuer = conf.property("jwt.issuer").getString()
    val realm = conf.property("jwt.realm").getString()
    val secret = conf.property("jwt.secret").getString()

    private val algorithm = Algorithm.HMAC256(secret)
    fun generateToken(username : String) : String {
        val token = JWT.create()
            .withAudience(auidence)
            .withIssuer(issuer)
            .withClaim("username",username)
            .withExpiresAt(Date(System.currentTimeMillis() + 6000))
            .sign(algorithm)
        DataBaseConnection.getDbCollection().updateOne(UserData::username eq username, setValue(UserData::token,token))
        return token
    }

    fun getVerifier() = JWT.require(algorithm)
                        .withIssuer(issuer)
                        .withAudience(auidence)
                        .build()

}