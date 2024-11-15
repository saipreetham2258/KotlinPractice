package com.lambda.higherorderfunctions

class Example1 {
    fun add(a : Int,b : Int) {
        var sum = a + b
        println("This is normal function call $sum")
    }

    fun add2(a : Int, b : Int, except : Myinterface) {
        var sum = a + b
        except.action(sum)
    }


    fun add3(a : Int, b : Int, action : (Int) -> Unit) {
        var sum = a + b
        action(sum)

    }
}
fun main() {
    val obj = Example1()
    obj.add(10,20)

    obj.add2(10,20, object : Myinterface{
        override fun action(sum: Int) {
           println("This is from interface call $sum")
        }
    })

    var myLambda : (Int) -> Unit = {s : Int -> println("This is from lambda call $s")}
    obj.add3(10,20,myLambda)

}
interface Myinterface {
    fun action(sum : Int)
}