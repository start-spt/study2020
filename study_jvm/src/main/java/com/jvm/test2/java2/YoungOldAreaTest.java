package com.jvm.test2.java2;

/**
 * 测试：大对象直接进去老年代
 * -Xms60m -Xmx60m -XX:NewRatio=2 -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 */
public class YoungOldAreaTest {
    public static void main(String[] args) {
        byte[] buffer=new byte[1024*1024*20];//20m
    }
}
