package com.jvm.test8.java2;

/**
 * 栈上分配测试
 * -Xmx1G -Xms1G -XX:-DoEscapeAnalysis -XX:+PrintGCDetails
 */
public class StackAllocation {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
        //查看执行时间
        long end=System.currentTimeMillis();
        System.out.println("花费时间为"+(end-start)+"ms");
        //为了方便查看堆内存的个数，线程sleep
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void alloc() {
        User user = new User();//为发生逃逸
    }

    static class User {

    }
}
