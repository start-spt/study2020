package com.jvm.test13.java2;

public class StringExer1 {
    public static void main(String[] args) {
        String s = new String("a") + new String("b");
        String s2 = s.intern();

        System.out.println(s2 == "ab");
        System.out.println(s == "ab");

    }
}
