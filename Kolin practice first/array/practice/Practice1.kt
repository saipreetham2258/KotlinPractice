package com.array.practice

import java.util.Arrays

class Practice1 {
    var a=arrayOf(1,2,3,4,5,6,7,8,9)
    fun methodOne(){

        for(i in 0..a.size-1){
            for(j in i..a.size-1){
                print("${a[j]} ")
            }
            println()
        }
        println(a.joinToString())
    }
    fun methodTwo() {
        println(a.joinToString())
    }
}

fun main() {
    var obj=Practice1()
    obj.methodOne()

    for(i in 0..obj.a.size-1){
        print("${obj.a[i]}, ")
    }
    println()

}