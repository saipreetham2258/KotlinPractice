package com.array.practice

class PracticeTwo {
    var a=arrayOf(9,6,8,4)
    fun methodOne() {
        for(i in 0..a.size-1){
            for(j in i..a.size-1){
                for(k in i..j){
                    print("${a[k]} ")
                }
                println()
            }
        }
    }
}
fun main() {
    var obj=PracticeTwo()
    obj.methodOne()
    println("Enter the index value of x :-")
    var x= readln()!!.toInt()
    try {
        println(obj.a[x])
    }
    catch (e : Exception){
        println(e)
    }


}