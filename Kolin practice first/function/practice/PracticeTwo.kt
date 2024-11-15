package com.function.practice

class PracticeTwo {
    fun methodOne(Obj : PracticeTwo){
        println("Hii this is member function means inner function of class")
    }
}
fun main() {
    val obj=PracticeTwo()
    println("This is main method")
    obj.methodOne(obj)

}