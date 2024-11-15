package com.propertyvsfunction.practice

class Practice1(val height : Int,val width : Int,val length : Int) {
    var usedSpace : Int = 0

//    fun getVolume() : Int {
//        return height*width*length
//    }

    val volume : Int = width*height*length
}
fun main() {

    val obj = Practice1(10,5,5)
    println(obj.volume)
//        println(obj.getVolume())
}
//when we call it wants to return same result so it must be "val" at this time use property otherwise use function