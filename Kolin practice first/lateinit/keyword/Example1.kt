package com.lateinit.keyword

class Example1 {

//             var str1 : String //if you declare like this you will get error to solve this use "lateinit keyword"
    lateinit var str : String
}
fun main() {

    val obj = Example1()
    obj.str = "sai preetham reddy"
    println(obj.str)                //before calling late init variable you have to initialize that variable if you call without initialise you get an error
                                    //like uninitialised property access exception
}
/* rules for using late int keyword
1 -> use late init key word before var variable
2 -> and initialise before calling
3 -> don't give nullable for var type if you are giving late init keyword */