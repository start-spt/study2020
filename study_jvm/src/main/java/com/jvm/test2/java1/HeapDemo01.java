package com.jvm.test2.java1;

/**
 * -Xms 20m -Xmx 20m
 */
public class HeapDemo01 {
    public static void main(String[] args) {
        System.out.println("start...");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end...");
    }
}
