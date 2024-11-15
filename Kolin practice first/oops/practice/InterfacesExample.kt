package com.oops.practice
interface i1{
    var a : Int
    val b : String
        get() = "hii"
    fun hii()

}
class InterfacesExample : i1 {   //in interface getter method is used when val is declared
    override var a = 10
    override val b = "Hello"
    override fun hii() {
        println("This is override method")
    }
}
fun main() {
    var obj = InterfacesExample()
    println(obj.a)
    println(obj.b)
    obj.hii()
}