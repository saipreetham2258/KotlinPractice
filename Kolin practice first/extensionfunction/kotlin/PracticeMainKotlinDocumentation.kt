package com.extensionfunction.kotlin

class PracticeMainKotlinDocumentation {
    val <T> List<T>.justOne: T?
        get() = if (isNotEmpty()) this[size - 1] else null

    fun accessingList(list : List<Int>) {
        println(list.justOne)

    }
}
//val <T> List<T>.justOne: T?
//    get() = if (isNotEmpty()) this[size - 1] else null //out side declared extension property


fun main() {
    val list: List<Int> = listOf(1, 2, 3, 4)
    // Accessing the justOne property will give the last element
    val obj = PracticeMainKotlinDocumentation()
    obj.accessingList(list)

//    println(list.justOne) //this is for accessing out side of class extension
}

