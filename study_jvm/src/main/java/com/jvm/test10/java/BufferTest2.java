package com.jvm.test10.java;

import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * 本地内存的OOM
 * Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
 * at java.nio.Bits.reserveMemory(Bits.java:694)
 * at java.nio.DirectByteBuffer.<init>(DirectByteBuffer.java:123)
 * at java.nio.ByteBuffer.allocateDirect(ByteBuffer.java:311)
 * at com.jvm.test10.java.BufferTest2.main(BufferTest2.java:18)
 */
public class BufferTest2 {
    private static final int BUFFER = 1024 * 1024 * 20;//20Mb

    public static void main(String[] args) {
        ArrayList<ByteBuffer> list = new ArrayList<>();

        int count = 0;
        try {
            while (true) {
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER);
                list.add(byteBuffer);
                count++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            System.out.println(count);
        }


    }
}
