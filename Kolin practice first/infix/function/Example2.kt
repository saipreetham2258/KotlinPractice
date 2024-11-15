package com.infix.function

data class Example2(val a : Double, var b : Double) {

}
operator fun Example2.minus(other : Example2): Example2 {
    return Example2(this.a - other.a, this.b - other.b)
}
fun main() {
    var vec1 = Example2(1.0,2.0)
    var vec2 = Example2(3.0,4.0)
    var res = vec1 - vec2
    println(res)
}
//Operator over loading