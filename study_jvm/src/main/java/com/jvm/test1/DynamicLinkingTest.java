package com.jvm.test1;

public class DynamicLinkingTest {

    int num=10;

    public void method01(){
        System.out.println("method01...");
    }

    public void methed02(){
        System.out.println("method02...");
        method01();
        num++;
    }

}
