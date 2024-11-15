package com.oops.practice

class CompanionObject {
    companion object hello {
        fun add() : CompanionObject {
            return CompanionObject() //it is returning the CompanionObject by this we are calling method() function
        }
    }
    fun method() {
        println("Hii sai preetham reddy")
    }
}
fun main() {
    val obj = CompanionObject.add()
    obj.method()

}