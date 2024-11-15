package com.oops.practice

open class InheritanceExample(val name : String) {
    fun eat() {
        println("I am ready to eat")
    }

    open fun sound() {
        println(name)
    }

}
class Hello(a : Int, name: String) : InheritanceExample(name){
    override fun sound() {
        println(name)
    }

}
class Hii(name : String) : InheritanceExample(name) {
    override fun sound() {
        println(name)
    }

}
fun main() {
    val hello = Hello(10,"saipreethamreddy")
    hello.eat()
    hello.sound()
}
