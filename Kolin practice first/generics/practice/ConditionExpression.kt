package com.generics.practice

class ConditionExpression {
}
fun check(a : Int,b : Int) = if(a>b) println("$a is bigger than @b") else println("$b is bigger than $a")
fun main() {
    var a : Int = 10
    var b : Int = 20
    println(check(a,b))
}