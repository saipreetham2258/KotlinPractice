package com.interoperabilitykotlinpackage

import com.interoperabilityjavapackage.PackageExample //we have to import packages when we do interoperability through packages

class PacakgeKotlinExample {
}
fun functionOneExample(a : Int, b : Int) : Int {
    return a + b
}
fun main() {
    var res : Int = PackageExample.methodOneExample(10,20)
    println("This is kotlin call of java method $res")
}