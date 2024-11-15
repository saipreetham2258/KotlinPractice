package com.oops.practice

class ConstructorExample constructor(a : String) {
    var c : String

    init {
        println("hii hello")
    }
    init {
        this.c = a
    }
    init {
        println(c)
    }
}
fun main() {
    var obj= ConstructorExample("sai preetham reddy")
    var obj2 = ConstructorExample("reddy")

}