package com.collections.kotlin

class HashSetExample {
}
fun main() {
    var hs= hashSetOf(2,3,1,2,5,7,5,2)
    println(hs)
    println(hs.indexOf(3))
    hs.add(10)
    println(hs)
    hs.remove(10)
    println(hs)

    hs.forEachIndexed({i,j -> println(j)}) //this is for each method of hashset
}