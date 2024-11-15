package com.collections.kotlin

import java.util.*

class ListToMutableList {
}
fun main() {
    var a= listOf(3,2,1,5,4)
    a= a.toMutableList()
    println(a)
    println("after adding element")
    a.add(100)
    println(a)
    println("after sorting")
    Collections.sort(a)
    println(a)

    var s=setOf(1,2,3,4,5)
    s=s.toMutableSet()
    println(s)
}