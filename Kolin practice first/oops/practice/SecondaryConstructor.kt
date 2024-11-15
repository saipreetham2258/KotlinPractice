package com.oops.practice



class SecondaryConstructor {
    constructor(a : Int,b : Int){
        println(a.plus(b))
    }


    constructor(a : String , b : String){
        println(a+" "+b)
    }
}
fun main() {
    var obj = SecondaryConstructor(10,20)
    var obj2 = SecondaryConstructor("sai","preetham")
}