package com.exceptionhandling.practice



class ExceptionExample1 {
}
fun main() {
    try{
        print("Enter the integer value : ")
        var a= readLine()!!.toInt()
        var b = 10
        var result = b/a
        println("result is $result")
    }
    catch (e : Exception){
        println(e)
    }
}