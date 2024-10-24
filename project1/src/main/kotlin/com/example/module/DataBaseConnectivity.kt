package com.example.module

import com.mongodb.client.MongoCollection
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection

object DataBaseConnectivity {
    fun datBaseConnectivity() : MongoCollection<LoginData>{
        val client = KMongo.createClient("mongodb://localhost:27017")
        val db = client.getDatabase("KotlinDataBase")
        val collection = db.getCollection<LoginData>()
        return collection
    }

}