package com.ranges.types

class Example1 {
}
fun main() {
    for(i in 1..10){
        print("$i ")
    }
    println()

    for(i in 1.rangeTo(10)) {
        print("$i ")
    }
    println()

    for(i in 10.downTo(1)) {
        print("$i ")
    }
    println()

    (1..2).forEach (::println)

    val num = (1..10)
    println(num.max())
    println(num.min())
    println(num.sum())
    println(num.first())
    println(num.last())
    println(num.average())
}