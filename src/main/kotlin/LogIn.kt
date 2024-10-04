package org.example

import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Projections
import org.bson.Document
import org.litote.kmongo.KMongo
import org.litote.kmongo.findOne

fun logIn() {
    println("Enter mail Id")
    val mail = readln()!!.toString()
    val string = "mongodb://localhost:27017"
    val client = KMongo.createClient(string)
    val db = client.getDatabase("KotlinDataBase")
    val coll = db.getCollection("user2")

//    for(i in coll.find()){
//        println(i.toJson())
//    }

    val query = Document("mail",mail)
    var result1 = coll.find(query).first()

    if(result1 != null){
        password()
    }
    else{
        println("Invalid mail Id ")
        logIn()
    }
}
fun password() {
    println("Enter password")
    val pas = readln()!!.toString()
    val string = "mongodb://localhost:27017"
    val client = KMongo.createClient(string)
    val db = client.getDatabase("KotlinDataBase")
    val coll = db.getCollection("user2")

    val query2 = Document("password",pas)
    var result2 = coll.find(query2).first()
    if(result2 != null){

        val que = Document()
        val projecti = Projections.fields(Projections.include("name"))
        val rs = coll.find(que).projection(projecti)

        lateinit var userName : String

        for(i in rs) {
          userName = i.getString("name")
        }
        println("Hoo! Thank you ${userName} for log In,  How may I help You! \uD83E\uDD73\n")

    }
    else {
        println("Invalid Password")
        password()
    }
}