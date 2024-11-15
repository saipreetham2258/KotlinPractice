open class Example2 {
    fun methodOne() {
        println("This method from Parent class")
    }
}
open interface one {
    fun methodTwo() {
        println("Hello")
    }
}
class two: Example2() , one{

}
fun method(a : Int) {
    when(a){
        1  -> println("first one")
        2  -> println("second one")
        3  -> println("third one")
        else -> println("Unknown")
    }
}
var i =0
fun methodTwo(name : String = "Sai"){
    println(name)

    if(i < 2){
        i++
        methodTwo()
    }
    i++
}

fun main() {
    println("Hello World")
    val c= two()
    c.methodOne()
    c.methodTwo()
    method(2)
    print("Enter the name of heavenly body: ")
    var name: Int= readln().toInt()
    when(name) {
        1 -> print("Sun is a Star")
        2-> print("Moon is a Satellite")
        else -> print("I don't know anything about it")
    }
    var str="saipreethamreddy"
    for(i in 0..str.length-1){
        print(str[i]+" ")
    }

    println()
    methodTwo()
    methodTwo("Preetham")


}