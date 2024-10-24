package com.example.module
import kotlinx.serialization.Serializable

@Serializable
data class LoginData(val userName : String,
                     val password : String)

@Serializable
data class User(val userName: String,
                val password: String)
