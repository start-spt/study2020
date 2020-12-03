package com.jvm.test0;

public class ClassInitTest {
    //任何一个类声明以后，内部至少存在一个类的构造器（显式，隐式）
    private static int num = 1;

    static {
        num = 2;
        number = 20;
    }

    private static int number = 10;

    public static void main(String[] args) {
        System.out.println(ClassInitTest.num);
        System.out.println(ClassInitTest.number);
    }
}
