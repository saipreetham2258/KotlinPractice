package com.oops.practice

//import com.function.practice.a

sealed class SealedClassMain {
    class success(val a : String) : SealedClassMain()
    class error(var b : String) : SealedClassMain()
    class Loading : SealedClassMain()
}
fun response(c : SealedClassMain) {
    when(c) {
        is SealedClassMain.Loading -> println("It is loading")
        is SealedClassMain.error -> println("got error due to ${c.b}")
        is SealedClassMain.success -> println("${c.a} Sucessfully completed")
    }
    //sealed is used to check the status in the time of network response like this example
}
fun main() {
    var obj = SealedClassMain.success("hii")
    response(obj)
}