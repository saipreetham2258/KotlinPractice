class InfixFunctionNotation {
}
fun main() {
    var a = 15
    var b = 12
    var c = 11
    // call using dot and parenthesis
    var result1 =(a > b).and(a > c)
    println("Boolean result1 = $result1")
    // call using infix notation
    var result2 =(a > b) and (a > c)
    println("Boolean result1 = $result2")


    var aa = 8

    // // call using infix notation
    var result11 = aa shr 2
    println("Signed shift right by 2 bit: $result11")
    // call using dot and parenthesis
    var result22 = aa.shr(1)
    println("Signed shift right by 1 bit: $result22")
}