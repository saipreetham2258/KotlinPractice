package com.oops.practice

abstract class AbstractClassExample {
    abstract var a : Int
    abstract fun add()
    fun sun(a : Int, b : Int) : Int {
        return a+b
    }

}
class Main : AbstractClassExample() {
    override var a : Int = 100
    override fun add() {
        println("hello from sub class")
    }
}
fun main() {
    val obj = Main()
    println(obj.a)
    obj.add()
    println(obj.sun(10,20))
}