package com.jvm.test8.java2;

/**
 * 标量替换
 * -Xmx100m -Xms100m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-EliminateAllocations
 */
public class ScalarReplace {
    public static class User {
        public int id;
        public String name;
    }
    public static void alloc(){
        User user = new User();
        user.id=5;
        user.name="testaa ScalarReplace";
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
        //查看执行时间
        long end=System.currentTimeMillis();
        System.out.println("花费时间为"+(end-start)+"ms");
    }
}
