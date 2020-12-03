package com.jvm.test13.java2;

/**
 * 如何保证变量s指向的是字符串常量池中的数据呢？
 * 有两种方式：
 * 方式一:  String s="spstart";//字面量的方式
 * 方式二:  调用intern()
 *          String s=new String("spstart").intern();
 *          String s=new StringBuilder("spstart").toString().intern();
 *
 */
public class StringIntern {
    public static void main(String[] args) {
        String s = new String("1");
        s.intern();//intern()有返回值，这个返回值才是指向字符串常量池的地址
        String s2="1";
        System.out.println(s==s2);//jdk6:false  jdk7/8:false

        String s3=new String("1")+new String("1");
        s3.intern();
        String s4="11";
        System.out.println(s3==s4);//jdk6:false  jdk/8:true
    }
}
