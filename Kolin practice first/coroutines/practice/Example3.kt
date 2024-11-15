package com.coroutines.practice
import kotlinx.coroutines.*

class Example3 {


}

fun main() = runBlocking {
    val obj : Job = launch{
        myOwnSuspend()
        delay(1000)
        println("hello world")

    }
}

suspend fun myOwnSuspend() = coroutineScope{
    launch {
//        delay(1000)
        println("hii")
    }
    println("Namastey")

}