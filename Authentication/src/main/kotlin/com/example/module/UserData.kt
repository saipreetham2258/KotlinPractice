package com.example.module
import kotlinx.serialization.Serializable


@Serializable
data class UserData(val name : String,
                    val id : Int,
                    val username : String,
                    val password : String,
                    val token : String = "")
