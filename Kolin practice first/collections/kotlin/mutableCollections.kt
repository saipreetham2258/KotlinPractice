package com.collections.kotlin

class mutableCollections {
}
fun main() {
    var a= arrayListOf(1,2,3,4,5,6,"sai")
    var b= listOf(11,22)
    println(a)
    a.add(88)
    //after adding element
    println(a)
    a.addAll(0,b)
    //after adding list to list
    println(a)
    a.remove(a[0])
    //after removing element at 0 index
    println(a)
    //if you want to do any operations like add remove in the list then use the arraylist

    var c: ArrayList<String> = arrayListOf("sai","preetham","reddy","saiii")
    var result = c.filter { it.startsWith("s") } //by using filter we can find the wanted data from all data
    println(result)

    //bys using the list iterator we can also print
    val ll:ListIterator<String> = c.listIterator()
    while(ll.hasNext()){
        println(ll.next())
    }

    //by using for each
    c.forEachIndexed( {i,j -> println("${c[i]}")} )



}