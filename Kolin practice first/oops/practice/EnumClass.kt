package com.oops.practice

enum class EnumClass(var days : Int) {
    Sunday(1),
    Monday(2),
    Tuesday(3),
    Wednesday(4),
    Thursday(5),
    Friday(6),
    Saturday(7)
}
fun main() {
    val obj = EnumClass.Wednesday
    println("Today is $obj")

    for(i in EnumClass.values()) {
        println("This is $i")
    }
    var obj3 = EnumClass.Sunday.days
    println(obj3) //returns day value 1

    var obj1 = EnumClass.Saturday.name
    println(obj1)

    var obj2 = EnumClass.values() //returns array
    for (i in obj2){
        println(i)
    }
    println(EnumClass.valueOf("Monday")) //it converts String to enum constants
}
