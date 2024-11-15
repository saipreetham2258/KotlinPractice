package com.coroutines.practice

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ChannelExample {
}
fun main() = runBlocking {
    val channel = Channel<Char>(5)

    val job1 = launch {
        for(i in 1..5) {
            var char = 64+i
            channel.send(char.toChar())
        }
        channel.close()
    }

    val job2 = launch {
        for(value in channel) {
            println("$value - ")
        }
    }
}