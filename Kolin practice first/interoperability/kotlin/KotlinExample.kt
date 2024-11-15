@file: JvmName("kotlinMethod")
package com.interoperability.kotlin
class KotlinExample {

}
fun add(a : Int, b : Int) : Int {
    return a + b
}
fun main() {
    println(java.multiplyMethod(10,20)) //calling java method in kotlin
}
