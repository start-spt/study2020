package com.jvm.test13.java2;

/**
 * intern()效率测试,空间使用上
 *
 * 结论：对于程序中大量存在的字符串，尤其其中存在大量重复字符串时，使用intern()可以节省内存空间
 *
 * */
public class StringIntern2 {
    static final int MAX_COUNT = 1000 * 10000;
    static final String[] arr = new String[MAX_COUNT];

    public static void main(String[] args) {
        Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        long start = System.currentTimeMillis();

        for (int i = 0; i < MAX_COUNT; i++) {
            //arr[i]=new String(String.valueOf(data[i%data.length]));//花费时间为：17792
            arr[i] = new String(String.valueOf(data[i % data.length])).intern();//花费时间为：5061
        }
        long end =System.currentTimeMillis();
        System.out.println("花费时间为："+(end-start));

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.gc();


    }
}
