package com.oops.practice

class InitBlock constructor(var a : Int,var b : Int){ //this is primary constructor
    init { //by using init we can do operations by using constructor parameters it is executed when the object is created in the same  way how we create
        if(a<b){
            println("a is less than b")
        }
        else{
            println("b is less than a")
        }
    }
    fun methodOne() {
        println("$a $b") //if we declare val or var then only we use that parameters to do operations but in init it is not required
    }
}
fun main() {
    var obj=InitBlock(10,20)
    obj.methodOne()
}