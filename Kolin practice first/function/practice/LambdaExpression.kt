package com.function.practice

class LambdaExpression {
}
fun main() {
    var c={a : Int , b : Int -> a + b}
    println(c(10,20))

    var f:(Int,Int) -> Int={ a , b -> a+b}
    println(f(20,30))


}