package com.oops.practice

class OopsExample1 {
    var name : String = ""
    var age : Int = 0
    var id : Int  =0
    var salary : Double =0.0
}
fun main() {
    var obj = OopsExample1()
    obj.name = "sai preetham reddy"
    obj.age = 22
    obj.id = 2258
    obj.salary = 15000.0


    println("name is ${obj.name}")
    println("age is ${obj.age}")
    println("id is ${obj.id}")
    println("salary is ${obj.salary}")

}