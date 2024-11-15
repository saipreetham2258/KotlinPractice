package com.coroutines.practice

import kotlinx.coroutines.*

class Example2 {

}
fun main() = runBlocking {
    val obj : Job = GlobalScope.launch(Dispatchers.Default){
        try{
            for(i in 1..100){
                delay(5)
                print("$i ")
            }
        }
        catch (e : CancellationException){
            println(e.message)
            println("Hii sai preetham reddy") //While you are using suspending functions to cancel the coroutines then there is exception call CancellationException so we have to handle Exception using try and catch
        }
        finally {
            withContext(NonCancellable) {
                delay(1000) //Generally we did not use delay in finally block if you use it in withContent(NonCancellable) coroutine scope
                println("Hello from finally")
            }
        }
        delay(1000)

    }

    delay(10)
    obj.cancel(CancellationException("Hii crash message"))
    obj.join()
}