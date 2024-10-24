package org.example

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.Document
import org.litote.kmongo.*
import java.io.File

fun main() {
    val list : User3 = getDataFromFile("C:\\Users\\tech.DESKTOP-CAFA711.000\\Desktop\\hii\\random_data.json")
    insertIntoDb(list,"KotlinDataBase")

}
fun getDataFromFile(filePath : String) : User3 {
    val obj = jacksonObjectMapper()
    return obj.readValue(File(filePath))
}

fun insertIntoDb(list : User3,db : String) {
    val url = "mongodb://localhost:27017"
    val client = KMongo.createClient(url)
    val dbb : MongoDatabase = client.getDatabase(db)
    val collection : MongoCollection<Document> = dbb.getCollection("user3")

    val details  = Document("name",list.name)
                    .append("age",list.age)
                    .append("student",list.isStudent)
    collection.insertOne(details)
    println("Successfully inserted")

}