package com.backingproperty.kotlin

class ClassRoom {
    private val _classRoomProperties = mutableListOf<String>()  //use only val in backing property and don't give type
    public  val  classRoomProperties : List<String>
        get() {
            return _classRoomProperties
        }

        fun addToClass(str : String) {
            _classRoomProperties.add(str)
        }
}

fun main() {
    val obj = ClassRoom()
    obj.addToClass("Board")
    obj.addToClass("Marker")
    obj.addToClass("Benches")
    obj.addToClass("Table")
    obj.addToClass("Chairs")

    println(obj.classRoomProperties)
//    obj.classRoomProperties.removeLast() //If we want to remove it is not possible to save the data from unwanted mistakes we use "Backing Property"
}