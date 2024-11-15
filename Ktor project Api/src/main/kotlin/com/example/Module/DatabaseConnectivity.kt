package com.example.Module

import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection

object DatabaseConnectivity {

    val client = KMongo.createClient("mongodb://localhost:27017")
    val db = client.getDatabase("KotlinDataBase")
    val collection = db.getCollection<Cart>("Cart")
}