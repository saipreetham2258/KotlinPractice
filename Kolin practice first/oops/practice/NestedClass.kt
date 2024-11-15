package com.oops.practice

class NestedClass {
    var name : String = "sai preetham reddy"
    var age : Int = 22

    class Hii {
        var id : Int = 2258
        var salary : Double = 15000.0
    }

    fun methodOuter() {
        println(NestedClass.Hii().id)
        println(NestedClass.Hii().salary)
    }
}
fun main() {
    var obj= NestedClass()
    obj.methodOuter()
}
/*
       Feature	                          Inner Class	                                 Nested Class
Reference to Outer Class	     Yes (can access outer class's members)        	No (cannot access outer class's members)
Declaration	                     Uses the inner keyword	                        No special keyword needed
Instantiation	                 Requires an instance of the outer class	    Can be instantiated directly    */