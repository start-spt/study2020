package com.jvm.test9.java;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * 测试：方法区内存溢出
 * *jdk7及以前
 * -XX:PremSize=10m -XX:MaxPremSize=10m
 *
 * jdk8及以后
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 * 8531
 * Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
 * at java.lang.ClassLoader.defineClass1(Native Method)
 * at java.lang.ClassLoader.defineClass(ClassLoader.java:763)
 * at java.lang.ClassLoader.defineClass(ClassLoader.java:642)
 * at com.jvm.test9.java.OOMTest.main(OOMTest.java:25)
 */
public class OOMTest extends ClassLoader {
    public static void main(String[] args) {
        int j = 0;
        try {
            OOMTest test = new OOMTest();
            for (int i = 0; i < 10000; i++) {
                //创建ClassWriter对象，用于生成类的二进制字节码
                ClassWriter classWriter = new ClassWriter(0);
                //指明：版本号，修饰符，类名，包名，父类，接口
                classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                //返回byte[]
                byte[] code = classWriter.toByteArray();
                test.defineClass("Class" + i, code, 0, code.length);//Class对象
                j++;
            }

        } finally {
            System.out.println(j);
        }
    }
}

