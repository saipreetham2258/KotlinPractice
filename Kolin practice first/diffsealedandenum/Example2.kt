package com.diffsealedandenum

enum class Example2(days : String) {
    Sunday("one"),
    Monday("two"),
    Tuesday("three") //here it accepts only one data type we cant change for this
}
fun find(mes : Example2) {
    when(mes) {
        Example2.Sunday -> println(mes.name+" "+mes.ordinal)
        Example2.Monday -> println(mes.name+" "+mes.ordinal)
        Example2.Tuesday -> println(mes.name+" "+mes.ordinal)
    }
}
fun main() {
    var obj = Example2.Monday
    find(obj)
}