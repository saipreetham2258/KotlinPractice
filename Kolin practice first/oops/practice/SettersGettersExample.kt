package com.oops.practice

class SettersGettersExample {
    var name : String = ""
        set(value) {
           if(value.length < 5){
               println("Invalid")
           }
            else{
                field = value
           }
        }
        get() = field
}
fun main() {
    var obj= SettersGettersExample()
    obj.name = "sai preetham reddy"
    println(obj.name)
}
//actually kotlin sets default setter and getter, but we are creating setter and getter instead of that to do our operations