package com.backingproperty.kotlin

class Example1 {
    private val _students = mutableListOf<String>()
    public  val students : List<String>
        get() {
            return _students
        }

        fun addTo(str : String) {
            _students.add(str)
        }


}
fun main() {
    var obj = Example1()
    obj.addTo("Books")
    obj.addTo("pens")
    obj.addTo("Uniform")

    println(obj.students)

}