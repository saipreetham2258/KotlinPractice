package org.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun againCall(array1 : Array<Array<Int>>,array2 : Array<Array<Int>>) {

    println("Select your vehicle type \n 1  Four wheeler \n 2  Two wheeler")
    print("Enter vehicle Type :")
    val input1 : Int = inputCheck(readln()!!.toString())

    if(input1 == 1){
        fourWheeler(array1,array2)
    }
    else if(input1 == 2){
        twoWheeler(array1,array2)
    }
    else {
        println("Enter correct input from the following ")
        runBlocking { delay(1000) }
        againCall(array1,array2)
    }
}