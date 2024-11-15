class LambadaExample {

}
fun high(a : String,b : (String) -> Unit) {
    println(b(a))
}
fun main() {
    var company = { println("Hello")}
    var student ={ a : Int, b:Int -> a+b}
    var employ : (Int,Int) -> Int  = { a, b -> a+b}
    company()
    println(student(10,20))
    println(employ(20,30))
    high("Hello world",::print)

}