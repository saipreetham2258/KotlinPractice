package com.example.module

import com.mongodb.client.FindIterable
import com.mongodb.client.MongoCollection
import io.ktor.server.config.*
import org.litote.kmongo.*

object DataBaseConnection {

    fun getDbCollection() : MongoCollection<UserData> {
        val client = KMongo.createClient("mongodb://localhost:27017")
        val db = client.getDatabase("KotlinDataBase")
        val collection = db.getCollection<UserData>()
        return collection
    }
}

fun getById(id : Int?): UserData? {
        val user = DataBaseConnection.getDbCollection().findOne(UserData::id eq id)
        return user
}

fun addUser(user : UserData): Boolean {
        val exist = DataBaseConnection.getDbCollection().findOneById(user.id)
        if(exist != null) {
            return false
        }
        else {
            DataBaseConnection.getDbCollection().insertOne(user)
            return true
        }
}

fun deleteUser(id : Int?) : Boolean{
    if(id!=null && DataBaseConnection.getDbCollection().findOne(UserData::id eq id) != null) {
        DataBaseConnection.getDbCollection().deleteOneById(id)
        return true
    }
    else {
        return false
    }
}

