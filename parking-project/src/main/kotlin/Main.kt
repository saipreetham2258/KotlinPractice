package org.example

fun main() {
    val array1 : Array<Array<Int>> = Array(2) {Array(2) {0} }
    val array2 : Array<Array<Int>> = Array(2) {Array(2) {0} }
    val obj = Parking()
    againCall(array1,array2)
}