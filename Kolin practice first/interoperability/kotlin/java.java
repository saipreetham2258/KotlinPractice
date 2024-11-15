
package com.interoperability.kotlin;

public class java {
    static int multiplyMethod(int a, int b) {
        return a * b ;
    }
    public static void main(String[] args) {
        int res = kotlinMethod.add(10,20); //calling kotlin function in java //here we use "kotlinMethod" instead of KotlinExample because we chane that by using "@file" Annotation
        System.out.print(res);
    }
}
