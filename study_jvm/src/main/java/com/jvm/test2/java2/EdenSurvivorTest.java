package com.jvm.test2.java2;

/**
 * -Xms600m -Xmx600m
 *
 * -XX:NewRatio                 设置新生代和老年代的比例，默认值是2
 * -XX:SurvivorRatio            设置新生代中Eden区与Survivor区的比例
 * -XX:-UseAaptivesSizePolicy   关闭自适应的内存分配策略
 * -Xmn                         设置新生代的空间的大小（一般不设置）
 */
public class EdenSurvivorTest {
    public static void main(String[] args) {
        System.out.println("我是来打酱油的。。。");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
