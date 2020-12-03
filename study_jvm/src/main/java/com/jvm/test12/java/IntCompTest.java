package com.jvm.test12.java;

/**
 * 测试解释器模式和JIT编译模式
 * -Xint :完全采用解释器模式                                             花费时间为：29768ms
 * -Xcomp :完全采用JIT编译模式，如果编译器出现问题，解释器会介入执行       花费时间为：6175ms
 * -Xmixed :采用解释器+即时编译器混合模式                                 花费时间为：5379ms
 *
 */
public class IntCompTest {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();

        testPrimeNumber(1000000);

        long end =System.currentTimeMillis();

        System.out.println("花费时间为："+(end-start));
    }

    public static void testPrimeNumber(int count) {
        for (int i = 0; i < count; i++) {
            //计算100以内的质数
            label:
            for (int j = 2; j <= 100; j++) {
                for (int k = 2; k <= Math.sqrt(j); k++) {
                    if (j % k == 0) {
                        continue label;
                    }
                }
            }
        }

    }
}
