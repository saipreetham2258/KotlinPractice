package com.oops.practice

class InnerClass {
    var name : String = "sai preetham reddy"
    var age : Int = 22

    inner class Hello {
        var id : Int = 2258
        var salary : Double = 15000.0

        fun getInfo() { //this is accessing the outer class properties in inner class
            println("$name $age")
        }
    }

    fun methodOfOuter() { //this is accessing the inner class properties in outer class function
        var obj3 = Hello()
        println(obj3.id)
        println(obj3.salary)
    }
}
fun main() {
    var obj= InnerClass() //object creation for outer class
    println(obj.name)
    println(obj.age)

    var obj2=obj.Hello() //object creation for inner class
    println(obj2.id)
    println(obj2.salary)

    obj2.getInfo()
    obj.methodOfOuter()
}