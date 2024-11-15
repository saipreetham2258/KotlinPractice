class TailRecurssion {
    fun methodOne(args : Array<Int>,a : Int,b : Int=0):Int {
        if (a <= 0) {
            return b
        }
        return methodOne(args, a - 1, b + args[a - 1])
    }
}
fun main() {
    var a= arrayOf(1,2,3,4,5,6,7)
    var obj=TailRecurssion()
    var result = obj.methodOne(a,a.size)
    println(result)

}