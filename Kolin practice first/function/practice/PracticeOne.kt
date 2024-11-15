package com.function.practice

class PracticeOne {
}
fun methodOne(obj : PracticeOne) {
    methodTwo(obj)
    println("This is method one")

}
fun methodTwo(obj : PracticeOne) {
    println("This is method Two")
}
fun main() {
    var obj=PracticeOne()
    methodOne(obj)
    println("This is main method")
}