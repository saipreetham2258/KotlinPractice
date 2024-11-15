package com.function.practice

class HigherOrdeFunctions {
}
var lamb={print("this is the higher order lambda")}
fun higherOrder(a : () -> Unit) {
    a()
    //this is the higher ordered function
}
fun main(){
    higherOrder(lamb)
}