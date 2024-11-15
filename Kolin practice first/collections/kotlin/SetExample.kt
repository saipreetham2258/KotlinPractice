package com.collections.kotlin

class SetExample {
}
fun main() {
    var seta : Set<Int> = setOf(1,2,3,4,5,6,5,4,3) //it is immutable
    println(seta)
    println("first element = ${seta.first()}  last element = ${seta.last()}   count = ${seta.count()}")


    //mutable set
    println("This is a mutable set")
    var setb = mutableSetOf(1,2,3,4,5,4,3,2,1)
    println(setb)
    println("after adding")
    setb.add(6)
    println(setb)
    println("after removing")
    setb.remove(1)
    println(setb)
}