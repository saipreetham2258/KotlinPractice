package com.coroutines.practice

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CoroutineCancelAndJoin {
}
fun main() = runBlocking {
    val job = launch {
        repeat(100) {
            i -> print("$i + ")
            delay(500)
        }

    }
    delay(2000)

    job.cancel()
    job.join()
    println("I am quit")

}