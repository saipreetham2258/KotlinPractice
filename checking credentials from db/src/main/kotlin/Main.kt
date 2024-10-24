package org.example

import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection

fun main() {
    totalCode()
}
fun totalCode() {

    println("welcome user")
    println("select option below")
    println("1   Sign Up")
    println("2   Log in")
    val inp = readln()!!.toInt()
    if(inp == 1) {
        val dB = Connection.databaseConnection("KotlinDataBase")

        var collection: MongoCollection<User2> = dB.getCollection<User2>()
        InseringDatatoDB(collection).addingData()


    }
    else{
        logIn()
    }


}
