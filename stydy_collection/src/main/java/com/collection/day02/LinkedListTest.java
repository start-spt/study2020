package com.collection.day02;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Author: start-spt
 * @Create: 2020/12/9 13:55
 */
public class LinkedListTest {
    @Test
    public void test1() {

        LinkedList<String> list = new LinkedList<String>();

        String tmp;
        long start = System.currentTimeMillis();    //ForEach
        for (String s : list) {
            tmp = s;
        }
        System.out.println("foreach spend:" + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            tmp = it.next();
        }
        System.out.println("Iterator spend;" + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            tmp = list.get(i);
        }
        System.out.println("for spend;" + (System.currentTimeMillis() - start));

    }
}
