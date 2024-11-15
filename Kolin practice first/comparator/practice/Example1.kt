package com.comparator.practice

data class Example1(var a : Int, var b : Int, val C : Any) {
}
fun main() {
    var (inp1,inp2,inp3) = Example1(10,20, listOf(10,20,30))
    println(inp1)
    println(inp2)
    println(inp3)
}
//This is the triple in kotlin data class
