package com.lazy.keyword

class ExampleOne1 {

}
fun main() {

    val pi : Float by lazy {
        3.14f
    }

    println(pi)

}
/* if you use lazy keyword it is initialised after calling that variable when you are calling another time it get from the
cache memory
and use only the val it is better to use
you have to use "by lazy" it is not initialised until you call that lazy variable
by using this we can save the memory because of unwanted variables and data like which are not used more
 */