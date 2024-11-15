package org.example

import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.bson.Document
import org.litote.kmongo.KMongo
import org.litote.kmongo.document
import org.litote.kmongo.getCollection

fun main() = runBlocking {
    val string = "mongodb://localhost:27017"
    val client = KMongo.createClient(string)
    val dataBase : MongoDatabase = client.getDatabase("KotlinDataBase")
    var collection : MongoCollection<Customer> = dataBase.getCollection<Customer>()

    createUser(collection)
    delay(1000)
    readData(collection)
    delay(1000)
    updateData(collection)
    delay(1000)
    deleteData(collection)
}

fun createUser(collection : MongoCollection<Customer>) {
    var user1 : Customer = Customer(101,22,"sai123@gmail.com")
    collection.insertOne(user1)

    var user2 : Customer = Customer(102,20,"ramu@gmail.com")
    collection.insertOne(user2)

}

fun readData(collection: MongoCollection<Customer>) {
    val data = collection.find()
    for(dat in data) {
        println(dat.toString())
    }
}
fun updateData(collection: MongoCollection<Customer>) {
    val filter = Document("id",101)
    val update = Document("\$set",Document("age",23))
    collection.updateOne(filter, update)
    println("Updated successfully")
    readData(collection)
}
fun deleteData(collection: MongoCollection<Customer>) {
    val filter = Document("age",23)
    collection.deleteOne(filter)
    println("delete successfully")
    readData(collection)
}