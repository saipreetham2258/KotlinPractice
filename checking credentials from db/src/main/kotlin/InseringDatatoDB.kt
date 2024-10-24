package org.example

import com.mongodb.client.MongoCollection

class InseringDatatoDB(val obj : MongoCollection<User2>) {

    var e : String = ""

    fun addingData() {
        println("Enter the name of user ")
        val a = readln().toString()
        println("Enter the Mobile Number of user ")
        val b : Long = readLine()!!.toLong()
        println("Enter the age of the user")
        val c =  readln().toInt()
        println("Enter the Techouts Id of the User")
        val d =  readln().toInt()
        println("Enter the mail Id")
        e = readln().toString()

        var mailverified : Boolean = mailcheck(e)

        if(mailverified == true) {
            println("Enter the password ")
            val f = readln().toString()
            val user2 = User2(a, b, c, d, e, f)
            obj.insertOne(user2)

            println("Details Entered sucessfully")
            println("Enter Mail and Password to login")
            logIn()

        }

    }

    fun mailcheck(input : String) : Boolean {
        val res : Boolean = mailCheck(input)
        if(res == true){
            println("mail format correct")
            return true
        }
        else{
            println("Enter mail again extension should be @gmail.com")
            e = readln().toString()
            return mailcheck(e)
        }
    }
}