package com.jvm.test0;


import sun.security.ec.CurveDB;

import java.net.URL;
import java.security.Provider;

public class ClassLoaderTest1 {
    public static void main(String[] args) {
        System.out.println("*******启动类加载器********");
        //获取BootstrapClassLoader能够加载的api的路径
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL element : urls) {
            System.out.println(element);
        }
        /**
         * *******启动类加载器********
         file:/C:/Program%20Files/Java/jdk1.8.0_151/jre/lib/resources.jar
         file:/C:/Program%20Files/Java/jdk1.8.0_151/jre/lib/rt.jar
         file:/C:/Program%20Files/Java/jdk1.8.0_151/jre/lib/sunrsasign.jar
         file:/C:/Program%20Files/Java/jdk1.8.0_151/jre/lib/jsse.jar
         file:/C:/Program%20Files/Java/jdk1.8.0_151/jre/lib/jce.jar
         file:/C:/Program%20Files/Java/jdk1.8.0_151/jre/lib/charsets.jar
         file:/C:/Program%20Files/Java/jdk1.8.0_151/jre/lib/jfr.jar
         file:/C:/Program%20Files/Java/jdk1.8.0_151/jre/classes
         */
        //从上面的路径随意选择一个类，看看他们的类加载器是什么:引导类加载器
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println(classLoader);

//        System.out.println("*******扩展类加载器*********");
//        String extDirs = System.getProperty("java.ext.dirs");
//        for (String path : extDirs.split(";")) {
//            System.out.println(path);
//        }
        /**
         * *******扩展类加载器*********
         C:\Program Files\Java\jdk1.8.0_151\jre\lib\ext
         C:\WINDOWS\Sun\Java\lib\ext
         */
        //从上面的路径随意选择一个类，看看他们的类加载器是什么:扩展类加载器
        ClassLoader classLoader1 = CurveDB.class.getClassLoader();
        System.out.println(classLoader1);
    }
}
