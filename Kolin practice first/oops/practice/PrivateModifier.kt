package com.oops.practice

private class PrivateModifier {
    private var a : Int = 10
    fun getValue() : Int {
        println(a)
        return a
    }
}
fun main() { //it is used in that class only we get to another class by using getter method
    var obj = PrivateModifier()
    println(obj.getValue())
}