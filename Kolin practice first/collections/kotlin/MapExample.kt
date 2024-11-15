package com.collections.kotlin

class MapExample {
}
fun main() {
    var m=mapOf(1 to "sai",2 to "preetham",3 to "reddy") //this is a immutable map which is created by mapOf
    println(m)

    var mm  = hashMapOf(1 to "hello",2 to "hii",3 to "namstey")
    println(mm)
    mm.put(4,"thanks") //to add
    println(mm)
    println("printing keys")
    println(mm.keys)
    println("printing values")
    println(mm.values)
    println("by using for loop")
    for(i in mm.keys){
        println(mm.get(i))
    }

    var m1 : HashMap<Int,String> = HashMap(4)
    m1.put(1,"sai")
    m1.put(2,"reddy")
    m1.put(3,"preetham")
    m1.put(4,"kanmantha")
    m1.put(5,"reddy")
    m1.put(6,"reddy")
    println(m1)

    var x: HashSet<Int> = HashSet(5) //declaring dynamic size to hash set
}