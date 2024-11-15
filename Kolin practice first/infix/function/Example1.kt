package com.infix.function



class Example1 {
}

// Define infix function for Int type
operator infix fun Int.plus(a: String): String {
    return (this + a)
}
fun methodOne(): String {
    return "sai"
}
fun main() {
    var b = 10

    println("The result of infix function is ${methodOne() + "preetham"}")
}
//operator and infix both are in this program

