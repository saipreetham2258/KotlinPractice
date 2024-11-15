package com.nullsafety.practice

class ExampleOne1 {

}
fun main() {
    var str : String? = null
    println("The str is ${str?.length}")

    var res1 = str.let {
        println(it?.length) //safe call operator to allow  null
    }

    var res2 : Int? = str?.length //it allows the null with out error
    println(res2)

//    var res3 = str!!.length //it throws null pointer exception if String is null
//    println(res3)

    var res4 = str?.length ?: -1  //if string is null it returns what the value we give after the "?:"
    println(res4)
}