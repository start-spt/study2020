package com.jvm.test13.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * -XX:StringTableSize=1009
 */
public class StringTest2 {
    public static void main(String[] args) {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("words.txt"));
            long start = System.currentTimeMillis();
            String data;
            while ((data = br.readLine()) != null) {
                data.intern();//如果字符串常量池中没有对应data的字符串的话，则在常量池中生成
            }
            long end = System.currentTimeMillis();
            System.out.println("花费的时间为：" + (end - start));//1009:780ms   100009:197ms

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
