package com.generics.practice
open class Phone(var os : String) {
    fun printOs() {
        println("Os is $os")
    }
}
class Android : Phone("android") {

}

class Ios : Phone ("Ios"){

}

class MyPhone<T : Phone>(val type : T) { //"Any"  holds anything cannot hold null it raises exception
//if you give class name it only allows only sub classes
}
fun main() {
    var obj = MyPhone(Ios())
    obj.type.printOs()
}
