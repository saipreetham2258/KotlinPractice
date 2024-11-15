package com.oops.practice

import javax.xml.crypto.Data

class DataClassExample {
}
data class man(var a : Int, var b : Int) {
    var c : Int = 0

}
fun main() {

    val obj = man(10,20)
    val obj1 = obj.copy(20,20) //copying obj to obj1
    val obj2 = obj.copy()

    println(obj)
    println(obj1)
    println(obj2)

    println(obj == obj2)//it compares the data in data class other than object reference

    //destructuring
    val (aa , bb) = obj
    println("$aa and $bb")

    val hashcode1 = obj.hashCode() //copying hash code of obj
    val hashcode2 = obj1.hashCode()
    val hashcode3 = obj.hashCode()

//    println(hashcode1)
//    println(hashcode2)
//    println(hashcode3)

    println("hashcode1 == hashcode2   ${hashcode1.equals(hashcode2)}")
    println("hashcode1 == hashcode3   ${hashcode1.equals(hashcode3)} \n")
    println("hashcode2 == hashcode3   ${hashcode2.equals(hashcode3)}")

}
//data class is used for data and it contains some methods like equals,copy,hashcode,toString toString gives the values which are present in the primary constructor