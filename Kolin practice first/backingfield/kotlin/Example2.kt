package com.backingfield.kotlin

class Example2 {
    var action = "sai preetham reddy"
        get() {
            return field
        }

        set(str : String) {
            field = str + " hii"
        }
}
fun main() {
    val obj = Example2()
    obj.action = "Kanmantha reddy"
    println(obj.action)
}