package com.collections.kotlin

class immutableCollections {
}
fun main() {
    var list=listOf(1,2,3,4,5,6)
    println("This is the immutable list")
    println(list)

    var list2=setOf(1,2,3,3,3,4,5)
    //this is the immutable set
    println(list2)

    val list3=mapOf(1 to "sai",2 to "preetham",3 to "reddy")
    //this is the immutable map
    println(list3)
}