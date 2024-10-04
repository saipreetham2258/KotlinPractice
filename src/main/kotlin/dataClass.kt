package org.example

import kotlinx.serialization.Serializable

@Serializable
data class User2(val name : String,
                 val Mobilenumber : Long,
                 val age : Int,val Id : Int,
                val mail : String,
                val password : String)