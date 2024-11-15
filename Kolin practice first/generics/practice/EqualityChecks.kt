package com.generics.practice

class EqualityChecks {
}
fun main() {
    val list1  = setOf("sai","preetham","reddy")
    val list2  = setOf("preetham","reddy","sai")

    if(list1 === list2) { //"==" checks the elements in it irrespective of order "===" checks the object references
        println("True")
    }
    else{
        println("False")
    }
}
