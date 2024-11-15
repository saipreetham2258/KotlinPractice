package com.function.practice

class InlinExample {
}
inline fun sum(a : () -> Unit){
    a()
}
fun main() {
   sum{print("hii this is inline function")}
}