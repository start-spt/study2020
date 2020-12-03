package com.jvm.test2.java2;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试 MinorGC,MajorGC,FullGC
 * -Xms9m -Xmx9m -XX:+PrintGCDetails
 */
public class GCTest {
    public static void main(String[] args) {
        int i = 0;
        try {
            List<String> list = new ArrayList<String>();
            String a = "springboot_demo";
            while (true) {
                list.add(a);
                a = a + a;
                i++;
            }
        } catch (Throwable t) {
            t.printStackTrace();
            System.out.println("遍历次数为:" + i);
        }


    }
}
