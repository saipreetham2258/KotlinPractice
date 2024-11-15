package com.coroutines.practice

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class LazyExecution {
}
fun main() = runBlocking {
    val res1 = async(start = CoroutineStart.LAZY) { methodOne() }  //By using this method is called when you print the async return value if you not print the async return value then the method is not called so it saves the memory
    val res2 = async(start = CoroutineStart.LAZY) { methodTwo() }
    println("${res1.await()} ${res2.await()}")
}

fun methodOne(): String {
    return "Hello"
}
fun methodTwo(): String {
    return "Sai preetham reddy"
}