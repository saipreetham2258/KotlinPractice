package com.example.customer.module

import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.Document
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection

object DataBaseConnection {
    fun dbConnection() : MongoCollection<CustomerDetails> {
        val uri = "mongodb://localhost:27017"
        var client = KMongo.createClient(uri)
        var dataBase: MongoDatabase = client.getDatabase("KotlinDataBase")
        var  collection : MongoCollection<CustomerDetails> = dataBase.getCollection<CustomerDetails>("Customer")
        return collection
    }
}