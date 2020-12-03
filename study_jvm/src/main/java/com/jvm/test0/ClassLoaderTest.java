package com.jvm.test0;

public class ClassLoaderTest {
    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //获取其上层：扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);//sun.misc.Launcher$ExtClassLoader@3feba861

        //获取其上层：获取不到引导类加载器
        ClassLoader bootstrapLClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapLClassLoader);//null

        //对于用户自定义类来说：默认使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //String类使用引导类加载器进行加载的---->Java的核心类库都是使用引导类加载器进行加载的
        //引导类加载器比较高端，只负责加载java的核心类库，而且引导类加载器是用C++写的
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);


    }
}
