open class Example{
    var n=100
  fun fun1(a : Int,b : String){
      println(a)
      println(b)
  }
}
class Oops: Example() {
    var a = ""
    var b = ""
    var c = ""
}
fun main(){
    val obj = Oops()
    obj.a= "Sai "
    obj.b= "Preetham "
    obj.c= "Reddy"
    print(obj.a)
    print(obj.b)
    println(obj.c)
    println(obj.n)
    obj.fun1(10,"sai preetham reddy")
}