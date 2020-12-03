package com.jvm.test13.java;

public class StringExer {
    String str=new String("good");
    char[] ch={'t','e','s','t'};

    public void change(String str,char ch[]){
        str="testaa ok";
        ch[0]='b';
    }

    public static void main(String[] args) {
        StringExer ex = new StringExer();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str);
        System.out.println(ex.ch);

    }

}
