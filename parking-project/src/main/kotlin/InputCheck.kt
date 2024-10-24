package org.example

fun inputCheck(input : String) : Int {
    try{
        val inp = input.toInt()
        return inp
    }
    catch(e : Exception) {
        println("Oops! Enter input type as integer")
        return inputCheck(readLine()!!.toString())
    }
}