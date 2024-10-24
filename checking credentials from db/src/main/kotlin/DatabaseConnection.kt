package org.example

import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.CoroutineDatabase

object Connection {
    private val string = "mongodb://localhost:27017"
    private val connect  = KMongo.createClient(string)

    fun databaseConnection(input : String) : MongoDatabase {
        val connection = connect.getDatabase(input)
        return connection
    }
}