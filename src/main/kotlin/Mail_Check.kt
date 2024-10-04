package org.example

fun mailCheck(pass : String) : Boolean {
    val res = Regex("[A-Za-z][A-Za-z]+[0-9]*[@](gmail)(.com)")
    val result = res.matches(pass)
    return result

}