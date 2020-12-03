package com.jvm.test13.java;

import java.util.HashSet;
import java.util.Set;

/**
 * jdk6中：
 * -XX:PremSize=6m -XX:MaxPremSize=6m -Xms6m -Xmx6m
 * <p>
 * jdk8中：
 * -XX:MetaspaceSize=6m -XX:MaxMetaspaceSize=6m -Xms6m -Xmx6m
 *  为什么java.lang.OutOfMemoryError: Java heap space和
 *  java.lang.OutOfMemoryError: GC overhead limit exceeded 交替出现
 */
public class StringTest3 {
    public static void main(String[] args) {
        //使用Set保持常量池的引用，避免full GC 回收常量池行为
        Set<String> set = new HashSet<>();
        //在short可以取值的范围内足以让6MB的PermSize或heap产生OOM
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());

        }
    }
}
