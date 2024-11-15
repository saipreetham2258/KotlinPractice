package com.example.customermodules
import kotlinx.serialization.Serializable

@Serializable
data class Customer(var id : String,
                    val name : String,
                    val age : Int,
                    val email : String,
                    val list : MutableList<UserList>)

@Serializable
data class UserList(val name : String,
                    val salary : String,
                    val address : String)

//val customers = mutableListOf<Customer>(Customer("10","sai preetham reddy",22,"Sai123@gmail.com"))


