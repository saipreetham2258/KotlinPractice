package com.function.practice

class TailRecurssion {
}
fun methodOne(a : Int , b : Int): Int {
    if(a==1){
        return b
    }
    return methodOne(a-1, (a * b))
}
fun main() {
    var a=1
    println(methodOne(5,a))
}