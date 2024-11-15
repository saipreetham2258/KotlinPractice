package com.array.practice

class ArrayDeclaration {
    var array = Array<Int>(5) {0}//"{0}" rhis is to initilise the array values
}
fun main() {
    val obj = ArrayDeclaration()
    obj.array[0] = 10
    obj.array[1] = 20
    obj.array[2] = 30
    obj.array[3] = 40
    obj.array[4] = 50
    for(i in obj.array){
        println(i)
    }
}