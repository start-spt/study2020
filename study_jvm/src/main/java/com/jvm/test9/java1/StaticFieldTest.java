package com.jvm.test9.java1;

/**
 * 静态引用对应的对象实体始终都存在堆空间
 * jdk7及以前
 * -Xms200m -Xmx200m -XX:PremSize=300m -XX:MaxPremSize=300m -XX:+PrintGCDetails
 * jdk8及以后
 * -Xms200m -Xmx200m -XX:MetaspaceSize=100m -XX:MaxMetaspaceSize=100m -XX:+PrintGCDetails
 *
 */
public class StaticFieldTest {
    private static byte[] arr=new byte[1024*1024*100];//100MB

    public static void main(String[] args) {
        System.out.println(StaticFieldTest.arr);
//        try {
//            Thread.sleep(1000000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
