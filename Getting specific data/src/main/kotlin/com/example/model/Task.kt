package com.example.model
import kotlinx.serialization.Serializable

enum class Priority {
    Low,Medium,High,Vital
}

@Serializable
data class Customer(val id : String,
                    val name : String,
                    val role : String,
                    val priority : Priority)

val list = mutableListOf<Customer>(Customer("101","sai preetham reddy","Developer",Priority.High),
    Customer("102","ritwik","Sanity",Priority.High),
    Customer("103","Inudhin","Frontend",Priority.Vital),
    Customer("104","Aryan","Frontend",Priority.High))
