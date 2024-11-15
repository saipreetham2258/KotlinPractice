package com.coroutines.practice

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CancelAndJoin {
}
fun main() = runBlocking{
    val job = launch(Dispatchers.Default) {
        var i = 0
        while(i < 5) {
            print("$i ")
//            delay(500) //We can use delay,yeild.withcontect etc to make coroutine cooperative
//            yield()
            Thread.sleep(500)
            i++
        }
    }
    println("Hii main")
    job.cancelAndJoin()
    println("Completed")
}