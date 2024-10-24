package com.example.module

import com.mongodb.client.MongoCollection
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection

object DataBaseConnectivity {

    fun dataBaseConnectivity() : MongoCollection<UserDetails> {
        val str = "mongodb://localhost:27017"
        val client = KMongo.createClient(str)
        val dataBase = client.getDatabase("KotlinDataBase")
        val collection = dataBase.getCollection<UserDetails>()
        return collection
    }
}