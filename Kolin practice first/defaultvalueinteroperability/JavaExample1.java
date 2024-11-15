
package com.defaultvalueinteroperability;

import kotlin.jvm.JvmOverloads;

public class JavaExample1 {

    public static void main(String[] args) {
        int result = KotlinExample1Kt.functionOne(10,20); //default value in kotlin function so we cant gave the third input by using annotation @JVMOverloads
        System.out.println("This from java call of Kotlin function "+result);

    }
}
