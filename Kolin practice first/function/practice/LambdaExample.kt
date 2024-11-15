package com.function.practice

class LambdaExample {
}
var a={ a : Int  -> a}
var b:(Int) -> Int ={ b -> b}
var lam={ a: Int,b : Int -> a+b }

fun main() {
    println(a(10))
    println(b(100))
    println(lam(10,20))
}