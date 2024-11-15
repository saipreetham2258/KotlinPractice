package com.coroutines.practice

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CoroutineScopeExample {
}
fun main()= runBlocking{
    doWorld()
    println("hii")
}
suspend fun doWorld() = coroutineScope {
    repeat(2){ //This will repates that many times that input you given
        launch {
            delay(1000)
            println("hello")
        }
        println("sai preetham reddy")
    }

}