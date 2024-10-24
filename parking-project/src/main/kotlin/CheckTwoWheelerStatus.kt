package org.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


fun checkTwoWheeler(inp2 : Int,array1 : Array<Array<Int>>,array2 : Array<Array<Int>>) = runBlocking {
    if(inp2 ==1 && array2[0][0]==0) {
        array2[0][0]=1
        println("Park your vehicle at slot no :- ${inp2}")
        delay(1000)
        println("Thank you for parking")
        delay(1000)
        againCall(array1,array2)
    }
    else if(inp2 == 2 && array2[0][1]==0){
        array2[0][1]=1
        println("Park your vehicle at slot no :- ${inp2}")
        delay(1000)
        println("Thank you for parking")
        delay(1000)
        againCall(array1,array2)
    }
    else if(inp2 ==3 && array2[1][0]==0) {
        array2[1][0]=1
        println("Park your vehicle at slot no :- ${inp2}")
        delay(1000)
        println("Thank you for parking")
        delay(1000)
        againCall(array1,array2)
    }
    else if(inp2 == 4 && array2[1][1]==0) {
        array2[1][1]=1
        println("Park your vehicle at slot no :- ${inp2}")
        delay(1000)
        println("Thank you for parking")
        delay(1000)
        againCall(array1,array2)
    }
    else {
        println("Oops!, slot $inp2 is currently not available please select another slot to park")
        delay(1000)
        twoWheeler(array1,array2)
    }
}