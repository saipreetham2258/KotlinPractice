class Example3 {
    var i=0
    fun methodOne() {
        println("Hello")
        if(i < 2){
            i++
            methodOne()
        }
    }
    fun Fact(num: Int, x:Int):Long{

        return if(num==1)   // terminate condition
            x.toLong()
        else
            Fact(num-1,x*num)   //tail recursion
    }
}

fun main() {
    var obj = Example3()
    obj.methodOne()
    var result = obj.Fact(5,1)
    println(result)
}
