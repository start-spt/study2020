package com.jvm.test13.java2;

public class StringExer2 {
    public static void main(String[] args) {
        //String s1="ab";//true
        //String s1=new String("ab");//false
        String s1 = new String("a") + new String("b");//true
        s1.intern();
        String s2="ab";
        System.out.println(s1==s2);
    }
}
