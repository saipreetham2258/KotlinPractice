package com.exceptionhandling.practice

class ExceptionExample2(message : String) : Exception(message) {
}
fun exp() {
    throw ExceptionExample2("Error occurred")
}
fun main() {
    var a : Int = readLine()!!.toInt()
    try {
        exp()
    }
    catch (e : Exception){
        println(e.message)
        e.printStackTrace()
        println(e)
    }
}