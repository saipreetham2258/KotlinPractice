package com.oops.practice

open class InheritancePractice3(val name : String) {
    init {
        println("hello sai preetham reddy")
    }

    open var size : Int = name.length.also {
        println("hello preetham $it")
    }

}
class Child(name : String, val lastName : String) : InheritancePractice3(name.replaceFirstChar { it.uppercase() }.also{
    println("this from child class $it") }) {
    init{
        println("this is base class init")
    }

    override var size: Int = (super.size + lastName.length).also { println("hii this is also from child $it") }
}
fun main() {
    var obj = Child("sai preetham reddy","reddy")
    println(obj.size)
}