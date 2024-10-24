package org.example

import com.mongodb.client.MongoClient
import org.litote.kmongo.*

fun main() {
    val uri = "mongodb://localhost:27017"
    val client = KMongo.createClient(uri)

    val db = client.getDatabase("KotlinDataBase")
    val coll = db.getCollection("user1")

    val update = coll.updateOne(user1::name eq readLine()!!.toString(),
        setValue(user1::age ,30)
    ).modifiedCount

    if(update > 0){
        coll.find().toList().forEach { result -> println(result) }
    }else {
        println("Not updated")
    }
}