package com.generics.practice

class Example1<T>(var arr : Array<T>) {

    fun add(element: T, find: (index: Int , elem : T?) -> Unit){
        for(i in arr.indices){
            if(arr[i] == element){
                find(i,arr[i])
                return
            }
        }
        find(-1,null)
    }

}
fun main() {
    var ex = Example1<Int>(arrayOf(1,2,3,4,5)) //this is int type of array
    ex.add(3) {index, elem ->
        println("index is $index")
        println("element is $elem")
    }

    var ex2 = Example1<String>(arrayOf("1","2","3","4","5")) //this String type of array
    ex2.add("3") {index, elem ->
        println("Index is $index")
        println("element is $elem")
    }
}