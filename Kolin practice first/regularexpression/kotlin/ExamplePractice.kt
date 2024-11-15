package com.regularexpression.kotlin

class ExamplePractice {
}
fun main() {
    val obj = Regex("[6-9][0-9]{9}")

    var res = obj.matches("9550297730")
    println(res)
}
