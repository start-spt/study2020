package com.jvm.test10.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * NIO
 */
public class BufferTest1 {
    private static final String TO = "F:\\testaa\\aa_中字_.mp4";
    private static final int _100Mb = 1024 * 1024 * 100;

    public static void main(String[] args) {
        long sum = 0;
        String src = "F:\\testaa\\aa_中字_.mp4";
        for (int i = 0; i < 3; i++) {
            String dest = "F:\\testaa\\aa_中字_" + i + ".mp4";
            sum += io(src, dest);//58461
            //sum+=di
        }
        System.out.println("花费总时间为：" + sum);
    }

    private static long io(String src, String dest) {
        long start = System.currentTimeMillis();

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);

            byte[] buffer = new byte[_100Mb];
            while (true) {
                int len = fis.read(buffer);
                if (len == -1) {
                    break;
                }
                fos.write(buffer, 0, len);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();

        return end - start;

    }
}
