package com.startspt.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: sptstart
 * @Create: 2020/12/1 14:29
 */
public class PropertiesTest {
    //Properties:常用来处理配置文件，key和value都是String类型。

    public static void main(String[] args) {
        InputStream fis = null;
        try {
            Properties pros = new Properties();
            ClassLoader classLoader = PropertiesTest.class.getClassLoader();// 读取属性文件xxxxx.properties
            fis = classLoader.getResourceAsStream("jdbc.properties");
            //FileInputStream fis = new FileInputStream("jdbc.properties");
            pros.load(fis);//加载流对应的文件

            String name = pros.getProperty("name");
            String password = pros.getProperty("password");

            System.out.println("name = " + name + ",password = " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
