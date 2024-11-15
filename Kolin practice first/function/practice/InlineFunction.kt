package com.function.practice

class InlineFunction {

}
inline fun high(lmb : () -> Unit){
    lmb()
    println("calling from inline function")
}
fun main() {
    high {print("hii this is the inline function")}
    //by using inline key word compiler will not create instance for lambda it copies the code this is the usage
}
