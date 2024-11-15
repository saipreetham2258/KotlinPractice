package com.extensionfunction.kotlin

class Example1 {
}
fun main() {
    var a : String = "sai "
    var b : String = "preetham "
    var c : String = "reddy"

    var res = a.concatThree(b, c)
    println(res)
}
fun String.concatThree(a : String, b : String) : String { //Here we use extension function for String class to add our convenient function like this we use this extension function
    return this + a + b
}