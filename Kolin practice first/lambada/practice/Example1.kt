package com.lambada.practice

class Example1 {

}
fun add( a : Int, b : Int , sub : (Int,Int) -> Int ): Int{
    println("hii")
    var c : Int = sub(a,b)
    return c
}
fun main() {
    println(add(10,20) {x,y  -> (x+y)})
}