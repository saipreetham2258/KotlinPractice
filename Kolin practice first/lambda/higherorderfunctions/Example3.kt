package com.lambda.higherorderfunctions

class Example3 {

    fun add(a : Int, b : Int, action : i1) {
       action.sum(a,b)
    }

}
interface i1 {
    fun sum(input1 : Int, input2 : Int)
}
fun main() {
    val obj = Example3()
    obj.add(10,20, object : i1 {
        override fun sum(input1: Int, input2 : Int) {// obj.add(10,20,object creation of interface like this and override interface function in this)
           println(input1 + input2)
        }

    })
}