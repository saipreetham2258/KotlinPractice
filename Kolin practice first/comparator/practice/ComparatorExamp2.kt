package com.comparator.practice

class ComparatorExamp2(var inp1 : Int,var inp2 : Int) {
    override fun toString(): String {
        return ("$inp1 = $inp2")
    }
}
class comp : Comparator<ComparatorExamp2> {
    override fun compare(a : ComparatorExamp2?, b : ComparatorExamp2?): Int {
        if(a == null || b == null ) {
            return 0
        }
        return a.inp1.compareTo(b.inp2)
    }

}

fun main() {
    var list = ArrayList<ComparatorExamp2>()
    list.add(ComparatorExamp2(10,12))
    list.add(ComparatorExamp2(13,15))
    list.add(ComparatorExamp2(9,16))

    list.sortWith(comp())
    println(list)
}