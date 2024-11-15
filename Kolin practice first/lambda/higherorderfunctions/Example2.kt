package com.lambda.higherorderfunctions

class Example2 {
    fun add(a : Int, b : Int, action : (Int,Int) -> Int) {
        println(action(a,b))
    }
}
//var a : String = "hello"
var myLambda : (Int,Int) -> Int = {a : Int,b : Int -> a + b} //This is the way to write Lambda
fun main() {
    val obj = Example2()
    obj.add(10,20){ a,b -> a + b }

    println(myLambda(10,20)) //This is the call of Lambda function
}

