package com.comparator.practice

class ComparatorExample(var height : Int,var weight : Int) {
    override fun toString(): String {
        return "ComparatorExample(firstName='$height', lastName='$weight')"
    }
}

class examp : Comparator<ComparatorExample> {
    override fun compare(inp1: ComparatorExample?, inp2: ComparatorExample?): Int {
        if(inp1 == null || inp2 ==null) {
            return 0
        }
        return inp1.height.compareTo(inp2.weight)
    }
}

fun main() {
    val list = ArrayList<ComparatorExample>()
    list.add(ComparatorExample(4,55))
    list.add(ComparatorExample(5,65))
    list.add(ComparatorExample(5,62))

    list.sortWith(examp())
    println(list)
}
