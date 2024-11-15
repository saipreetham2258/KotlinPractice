package com.higherorderfunction

class Example1 {
}
fun methodOne(a : Int , b : Int, sum : (Int,Int) -> Int): Int {
   return sum(a,b)
}
fun sum ( a : Int, b : Int) = a + b
var a : (String) -> String = { str -> str.uppercase() } //lambda function
var b : (String) -> String = {it.uppercase()}
var c : (String,String) -> String = { a,b -> a + b}

fun main() {
   var type1 = methodOne(10,20,::sum)
   var type2 = methodOne(10,20) {a,b -> a+b}

    println(type1)
    println(type2)
    println(a("sai preetham reddy"))
    println(b("kanmantha reddy"))
    println(c("sai","preethamreddy"))
}