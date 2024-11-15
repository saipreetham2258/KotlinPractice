package com.infix.function

class OperatorOverloading(var a : Int = 0) {
    override fun toString(): String {
        return "OperatorOverloading(a=$a)"
    }
}
operator infix fun OperatorOverloading.plus(other : OperatorOverloading) : OperatorOverloading {
    return OperatorOverloading(this.a + other.a )
}
fun main() {
    var obj = OperatorOverloading()
    var obj1 = OperatorOverloading()

    obj.a = 10
    obj1.a = 20

    var res  = obj + obj1
    println(res)
}
