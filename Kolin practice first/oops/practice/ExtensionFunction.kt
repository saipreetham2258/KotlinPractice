package com.oops.practice

class ExtensionFunction(var a : Int, var b : Int) {
    fun add(): Int {
        return a + b
    }
}
fun main() {
    fun ExtensionFunction.sub() : Int { //this is function extension of class ExtensionFunction and we can also do extension for pre-defined functions
        return a - b
    }

    var obj = ExtensionFunction(10,20)
    println("addition of ${obj.a} and ${obj.b} is ${obj.add()}")
    println("subtraction of extension function ${obj.a} and ${obj.b} is ${obj.sub()}")
}