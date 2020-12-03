package com.jvm.test10.java;

import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 *   IO                NIO(New IO/Non-Blocking IO)
 *   byte[]/char[]     Buffer
 *   Stream            Channel
 *
 *   查看直接内存的占用与释放
 */
public class BufferTest {
    private static final int BUFFER=1024*1024*1024;//1GB

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER);
        System.out.println("直接内存分配完毕，请指示！");

        Scanner scanner = new Scanner(System.in);
        scanner.next();

        System.out.println("直接内存开始释放。");
        byteBuffer=null;
        System.gc();
        scanner.next();
    }
}
