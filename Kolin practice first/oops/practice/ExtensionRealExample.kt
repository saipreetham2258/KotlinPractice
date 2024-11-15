package com.oops.practice

class ExtensionRealExample {
    fun hello() {
        println("Hii sai preetham reddy")
    }
}
fun main() {
    fun ExtensionRealExample.hi() {
        println("hii")
    }

    val obj = ExtensionRealExample()
    obj.hi()
}
