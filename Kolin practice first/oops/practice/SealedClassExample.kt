package com.oops.practice

sealed class SealedClassExample {
    class man(var a : Int) : SealedClassExample() {

    }
    class Person(var b : String) : SealedClassExample() {

    }

}
fun methodOne(obj : SealedClassExample) {
    when(obj) {
        is SealedClassExample.man -> println("hello this is man ${obj.a}")
        is SealedClassExample.Person -> println("This is Person class ${obj.b}")

    }
}
fun main() {
    var obj = SealedClassExample.man(10)
    var obj1 = SealedClassExample.Person("sai preetham reddy")

    methodOne(obj)
    methodOne(obj1)

}