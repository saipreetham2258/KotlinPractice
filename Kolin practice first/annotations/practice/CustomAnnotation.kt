package com.annotations.practice
@Target(AnnotationTarget.CONSTRUCTOR, AnnotationTarget.LOCAL_VARIABLE) //This if for declaring where we are using the annotation
annotation class UserDefinedAnnotation

class CustomAnnotation  @UserDefinedAnnotation constructor(val a : Int) {

        fun hii() {
            println("Hii hello")
            println("The value is $a")
        }

}
fun main() {
    val obj = CustomAnnotation(5)
    obj.hii()
    @UserDefinedAnnotation val input : String = "sai preetham reddy"
    println(input)
}
/*This is the declaration of Custom defined annotation like target is used to declare where the annotation is used, declare them by using AnnotationTarget class methods
and now declare custom annotation class by class name with keyword annotation and after use this annotation where you are declared in target annotation */