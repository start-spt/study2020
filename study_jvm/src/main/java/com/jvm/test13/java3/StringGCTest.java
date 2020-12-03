package com.jvm.test13.java3;

/**
 * String的垃圾回收：
 * -Xms15m -Xmx15m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails
 */
public class StringGCTest {
    public static void main(String[] args) {
        for (int i = 0; i <10000 ; i++) {
            String.valueOf(i).intern();
        }
    }
}
