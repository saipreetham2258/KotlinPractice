package com.function.practice

class HigherOrderFunctionExample2 {
}
//this is another way of higher order functions
fun higherOrderFunction(a : Int, b : Int , fn : (Int , Int) -> Int) {
    println(fn(a,b))
}
fun main() {
    higherOrderFunction(10,20,{a,b -> a+b})
    high(20,20,::add)
}


//this is one way of higher order functions
fun high( a: Int, b : Int,ff : (Int,Int) -> Int){
    println(ff(a,b))
}
fun add(a: Int, b: Int):Int{
    return a+b
}