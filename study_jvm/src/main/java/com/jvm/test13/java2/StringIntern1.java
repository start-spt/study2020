package com.jvm.test13.java2;

public class StringIntern1 {
    public static void main(String[] args) {
        /**
         * true
         * true
         * true
         */
        String s3 = new String("1") + new String("1");
        String s5 = s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
        System.out.println(s5 == s4);
        System.out.println(s5 == s3);

        System.out.println("----------------------------------------");

        /**
         * false
         * true
         * false
         */
        String ss3 = new String("2") + new String("2");
        String ss4 = "22";
        String ss5 = ss3.intern();
        System.out.println(ss3 == ss4);
        System.out.println(ss5 == ss4);
        System.out.println(ss5 == ss3);
    }
}
