package com.predicates.practice

class PredicateExample1 {
}
fun main() {
    var list = listOf<Int>(1,4,3,10,47,25,31)

    var res1 = list.all { it -> it >  10 }
    println("res1 = $res1")

    var res2 = list.any { it -> it > 10 }
    println("res2 = $res2")

    var res3 = list.find { it -> it < 10 }
    println("res3 = $res3")

    var a = {num:Int -> num<10} //we can like this and also by using lambda like above declared
    var res4 = list.count(a)
    println("res4 = $res4")

    var res5 = list.contains(10)
    println("res5 = $res5")

    var res6 = list.subList(0,2)
    println("res6 = $res6")

    var res7 = list.size
    println("res7 = $res7")
}
//predicates checks the condition and return true or false max other than some methods