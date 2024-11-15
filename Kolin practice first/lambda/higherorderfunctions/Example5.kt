package com.lambda.higherorderfunctions

class Example5 {
    var lambda : (Int,Int) -> Int = {a , b -> a + b}

    fun add(a : Int , b : Int, lam : (Int,Int) -> Int) {
        println(lam(a,b))
    }

    fun add2(a : Int , b : Int, action : ii1) {
        val sum = a+b
        action.add(sum)
    }

}
fun main() {
    val obj = Example5()
    println(obj.lambda(10,20))

    obj.add(30,30, obj.lambda)

    obj.add2(10,10, object : ii1{
        override fun add(str: Int) {
            println(str)
        }

    })
}
interface ii1 {
   fun add(str : Int)
}