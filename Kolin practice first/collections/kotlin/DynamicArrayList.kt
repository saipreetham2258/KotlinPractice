package com.collections.kotlin

class DynamicArrayList {
}
fun main() {
    var a = ArrayList<Int> ()
    println("enter the values")
    a.add(readLine()!!.toInt())
    a.add(readLine()!!.toInt())
    a.add(readLine()!!.toInt())
    println(a)
//    a.clear() // it is clear all the list or any thing
    println(a)
    a.addAll(0,a) //adding same list to that list
    println(a)

}