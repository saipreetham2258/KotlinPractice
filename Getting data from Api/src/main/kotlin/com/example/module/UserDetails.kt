package com.example.module
import io.ktor.client.*
import kotlinx.serialization.Serializable
import io.ktor.client.engine.cio.*

@Serializable
data class UserDetails(val userId : Int,
                       val id : Int,
                       val title : String,
                       val body : String)
val client = HttpClient(CIO)
