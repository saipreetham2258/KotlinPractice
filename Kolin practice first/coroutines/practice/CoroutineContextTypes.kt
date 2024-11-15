package com.coroutines.practice

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CoroutineContextTypes {
}
fun main() = runBlocking {
    val confined = launch {
        println("C1 ${Thread.currentThread().name}")
        delay(1000)
        println("after delay : c1 ${Thread.currentThread().name}")
    }

    val parameter = launch(Dispatchers.Default) {
        println("C2 ${Thread.currentThread().name}")
        delay(1000)
        println("after delay : C2 ${Thread.currentThread().name}")
    }

    val undefined = launch(Dispatchers.Unconfined) {
        println("C3 ${Thread.currentThread().name}")
        delay(1000)
        println("after delay : C3 ${Thread.currentThread().name}")
    }

    val coroutineContext = launch(coroutineContext) {
        println("C4 ${Thread.currentThread().name}")
        delay(1000)
        println("after delay : C4 ${Thread.currentThread().name}")
    }
}