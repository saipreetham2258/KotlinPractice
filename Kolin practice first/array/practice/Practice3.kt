package com.array.practice

class Practice3 {
}
fun main() {
    val v  = ArrayList<Int>()
    println("Enter the size of the arraylist")
    for(i in 0..readLine()!!.toInt()-1){
       v.add(readLine()!!.toInt())

    }
    println(v)
    println(v.first())
    println(v.last())
    println(v.contains(2))
}