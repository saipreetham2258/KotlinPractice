package com.diffsealedandenum

sealed class Example1 {
    class A(val one : Int) : Example1()
    class B(val two : String) : Example1()
    class C(val three : Double) : Example1()
    object D : Example1()

}
fun find(mess : Example1) {
    when(mess) {
        is Example1.A -> println(mess.one)   //in sealed class it can accept the different class parameters but in enum it accepts only one
        is Example1.B -> println(mess.two)
        is Example1.C -> println(mess.three)
        Example1.D -> println("This is object")
    }
}
fun main() {
    var obj = Example1.A(10)
    find(obj)

    var obj1 = Example1.D
    find(obj1)
}