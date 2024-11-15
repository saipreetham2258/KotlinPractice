package com.generics.practice

import java.util.Collections

class Example2<T>(vararg items : T) {
    var list = items.toMutableList()

    override fun toString(): String {
        return list.toString() // Return a string representation of the list
    }

    fun <E> mutableStackOf(vararg elements: E) = Example2(*elements)
}

//little bit confuse

fun main() {
    var obj=Example2<Int>(10,30,30,20,40,60)
    println(obj.list)

    var obj1 = Example2<String>("sai","preetham","reddy","kanmantha","reddy")
    println(obj1.list)

//    Collections.sort(obj.list)
//    println(obj.list)

    println(obj.list.last())
    println(obj.list.first())


    val stack = obj.mutableStackOf(0.62, 3.14, 2.7)
    println(stack.toString())
}
