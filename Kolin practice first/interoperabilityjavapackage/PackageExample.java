package com.interoperabilityjavapackage;


import com.interoperabilitykotlinpackage.PacakgeKotlinExampleKt; ////we have to import packages when we do interoperability through packages

public class PackageExample {
    public static int methodOneExample(int a, int b) {
        return a * b;
    }
    public static void main(String[] args) {
        int result = PacakgeKotlinExampleKt.functionOneExample(10,20);
        System.out.print("This call of kotlin function from java program "+result);

    }
}
