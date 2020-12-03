package com.jvm.test10.java;

import sun.misc.Unsafe;

import javax.lang.model.element.VariableElement;
import java.lang.reflect.Field;

/**
 * -Xmx20m -XX:MaxDirectMemorySize=10m
 *
 * Exception in thread "main" java.lang.OutOfMemoryError
 * at sun.misc.Unsafe.allocateMemory(Native Method)
 * at com.jvm.test10.java.MaxDirectMemorySizeTest.main(MaxDirectMemorySizeTest.java:20)
 */
public class MaxDirectMemorySizeTest {
    private static final long _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);

        while (true) {
            unsafe.allocateMemory(_1MB);
        }

    }
}
