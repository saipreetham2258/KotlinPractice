package org.example


import com.mongodb.client.MongoClients
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.Document

fun main() {
    val connection = MongoClients.create("mongodb://localhost:27017") //creating connection
    val db : MongoDatabase = connection.getDatabase("KotlinDataBase") //connecting to db
    val connect : MongoCollection<Document> = db.getCollection("list") //connecting to collection
    val doc = Document("name","K sai preetham reddy").append("age" , 22).append("id",2258).append("aadhar no",834286360459) //inserting data

    connect.insertOne(doc)

    println("sucessfully inserted")

    for(x in connect.find()){  //retrieving data from data base
        println(x.toJson())
    }

    connection.close()


}