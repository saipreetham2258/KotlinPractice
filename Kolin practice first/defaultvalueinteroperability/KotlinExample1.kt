
package com.defaultvalueinteroperability
class KotlinExample1 {

}
@JvmOverloads //it is used in the above the method where it required
fun functionOne(a : Int, b : Int, c: Int = 10) : Int {
    return a + b + c
}
fun main() {
    var res = functionOne(10 , 20)
    println("This from Kotlin call of Kotlin function $res")
}