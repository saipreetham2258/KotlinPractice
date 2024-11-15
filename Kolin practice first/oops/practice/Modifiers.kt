package com.oops.practice
//protected modifier
open class A {
    protected var b : Int = 190
}
class Modifiers: A(){
    fun getValue() : Int {
        return b
    }
}
fun main() {
    var obj = Modifiers()
    println(obj.getValue())
}
