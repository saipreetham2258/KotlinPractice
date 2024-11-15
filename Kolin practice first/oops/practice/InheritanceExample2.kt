package com.oops.practice

open class InheritanceExample2(a : Int) {
    open fun methodOne() {
        println("hello hii sai preetham reddy")
    }
}
class Example(a: Int) : InheritanceExample2(a) {
    override fun methodOne() {
        println("This is from sub class")
    }

}
fun main() {
    var obj = Example(10)
    obj.methodOne()
}
