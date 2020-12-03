package com.jvm.test2.java2;

import java.util.ArrayList;
import java.util.Random;

/**
 * -Xms600m -Xmx600m
 */
public class HeapInstanceTest {
    byte[] buffer=new byte[new Random().nextInt(1024*200)];

    public static void main(String[] args) {
        ArrayList<HeapInstanceTest> list=new ArrayList<HeapInstanceTest>();
        while (true){
            list.add(new HeapInstanceTest());
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
