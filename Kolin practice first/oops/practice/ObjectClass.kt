package com.oops.practice

/*data*/ class ObjectClass(var bookName : String ,var bookPrise : Int){
    override fun toString(): String {
        return "ObjectClass(bookName='$bookName', bookPrise=$bookPrise)"
    }
}

object hello {//This is a object class which is like a singleton object here "hello" is the object of object class
    var examp = ArrayList<ObjectClass>()

    init {
        println("This is a init block")
    }
}

fun main() {
    hello.examp.add(ObjectClass("java",50))
    hello.examp.add(ObjectClass("Kotlin",60))
    hello.examp.add(ObjectClass("Sql",40))
    println(hello.examp.toString()) //to print we can override to String otherwise give class name as Data

}