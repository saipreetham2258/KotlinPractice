package com.coroutines.practice

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("Fetching data...")

    // Launch a coroutine to fetch data
    val data = async { fetchData() }

    // Do other work while waiting for the data
    println("Doing other work...")

    // Await the result from the coroutine
    println("Data received: ${data.await()}")
}

suspend fun fetchData(): String {
    delay(2000) // Simulate a long-running operation (e.g., network call)
    return "Sample Data"
}