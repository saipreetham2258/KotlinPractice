package com.function.practice

class Run {
    var name : String = "sai preetham reddy"
    var age : Int = 22
}
fun main() {
    var obj : Run? = Run()
        var result = obj?.run {
        println(this.name)
        println(this.age)
        this.age + 5
    }
    println(result)
    // this is the combination of let and with functions
    //refer context obj is this
    //return lambda result
    //? is nullable to write
}