package com.oops.practice

enum class EnumMain(var duration : Int) {
    Red(30),
    Green(35),
    yellow(5);

    fun method() {
        println("$name light duration is $duration sec")
    }
}
fun main() {
    var obj = EnumMain.Red
    obj.method()
//in this ordinal and name properties are present methods like valueOf() and values()
    var obj1 = EnumMain.Green
    obj1.method()

    var obj2 = EnumMain.yellow
    obj2.method()
}