package com.backingfield.kotlin

class Example1 {
    var age : Int = 10

        get() {
            return field  //Use "field" don't use age
        }

        set(input : Int) {
            field = input //Here use "field" don't use ade
        }
    var str = "sai"
}

fun main() {
    val obj = Example1()
    obj.age = 30
    println(obj.age)

    obj.str = "sai preetham reddy"
    println(obj.str)  //In this kotlin will create setters and getters to assign value and to print by default we didn't write explicitly
}
//If you want to create setters and getters then use the backing field "field" otherwise don't create