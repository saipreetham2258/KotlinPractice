package com.oops.practice

import java.util.*

enum class EnumClassExample2(var day : String) {
    Sunday("sunday"){
        override fun add() {
            println("this is Sunday constant")
        }
    },
    Monday("monday"){
        override fun add() {
            println("This is Monday Constant")
        }
    },
    Tuesday("tuesday"){
        override fun add() {
            println("This is Tuesday Constant")
        }
    };
    abstract fun add()

}
fun main() {
    val obj = EnumClassExample2.Sunday
    println(obj)
    obj.add()
    println(obj.ordinal) //it gives index value of constant
    println(obj.name)  //it gives the name of the day
    println(EnumClassExample2.Sunday.day)//it gives parameter of the constant
    println(EnumClassExample2.valueOf("Sunday"))//it returns the String to constant
    var arr = EnumClassExample2.values() //it returns array
    println(Arrays.toString(arr))

}