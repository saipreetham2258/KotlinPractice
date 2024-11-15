package com.oops.practice

class GenericsExample(var array : Array<Int>){
    fun check(element : Int , find : (index : Int,Element : Int?) -> Unit) {
        for(i in array){
            if(array[i] == element){
                find(i,array[i])
                return
            }
        }
        find(-1,null)
    }
}
fun main() {
    var arr = arrayOf(1,2,3,4,5)
    var obj = GenericsExample(arr)
    obj.check(5) { index, Element ->
        println("Index value is $index")
        println("Element is $Element")
    }

}
