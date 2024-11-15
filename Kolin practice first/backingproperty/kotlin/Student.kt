package com.backingproperty.kotlin

class Student {
    private val _books = mutableListOf<String>()
     public val books:List<String>

         get() = _books


    fun addToList(str : String) {
        _books.add(str)
    }
}

fun main() {
    val student = Student()
    student.addToList("Java")
    student.addToList("Python")
    student.addToList("Sql")
    student.addToList("Kotlin")

    println(student.books)
//    student.books.removeLast()
//    println(student.books)
}
//here if by mistakenly want to remove the data in books it is not possible to remove so this is backing field