package org.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun checkFourWheeler(inp1 : Int,array1 : Array<Array<Int>>,array2 : Array<Array<Int>>) = runBlocking {
    if(inp1 ==1 && array1[0][0]==0){
        array1[0][0]=1
        println("Park your vehicle at slot no :- ${inp1}")
        delay(1000)
        println("Thank you for parking")
        delay(1000)
        againCall(array1,array2)

    }
    else if(inp1 ==2 && array1[0][1]==0){
        array1[0][1]=1
        println("Park your vehicle at slot no :- ${inp1}")
        delay(1000)
        println("Thank you for parking")
        delay(1000)
        againCall(array1,array2)

    }
    else if(inp1 ==3 && array1[1][0]==0) {
        array1[1][0]=1
        println("Park your vehicle at slot no :- ${inp1}")
        delay(1000)
        println("Thank you for parking")
        delay(1000)
        againCall(array1,array2)

    }
    else if(inp1 == 4 && array1[1][1]==0) {
        array1[1][1]=1
        println("Park your vehicle at slot no :- ${inp1}")
        delay(500)
        println("Thank you for parking")
        delay(500)
        againCall(array1,array2)

    }
    else {
        println("Oops!, slot $inp1 is currently not available please select another slot to park")
        delay(1000)
        fourWheeler(array1,array2)
    }
}
