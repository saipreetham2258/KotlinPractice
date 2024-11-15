package com.lambada.practice

class Example2 {

}
fun main() {
    val arr : Array<Int> = arrayOf(1,2,3,4,5)
    val ans = arr.map { it * it } //by using map we can do double are any operation in this we have to use "it"
    println(ans)

    val ans1 = arr.filter { it%2 ==0 } //by using filter we can also do operations using "it"
    println(ans1)

    val ans2 : Int = arr.reduce { ac, i -> ac+i } //by using reduce we can do the sum of elements
    println(ans2)

    val max : Int = arr.reduce { acc, i -> if(i>acc) i else acc } //by using reduce we can also find the max and min
    println(max)

}