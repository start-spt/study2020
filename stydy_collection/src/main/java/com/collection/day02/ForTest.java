package com.collection.day02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk 5.0 新增了foreach循环，用于遍历集合、数组。
 *
 *
 *
 * @Author: start-spt
 * @Create: 2020/12/4 20:51
 */
public class ForTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //for(集合元素的类型 局部变量 : 集合对象)
        //内部仍然调用了迭代器。
        for (Object obj : coll) {
            System.out.println(obj);
        }
        
    }

    @Test
    public void test2() {
        int[] arr=new int[]{1,2,3,4,5,6};

        //for(数组元素的类型 局部变量 : 数组对象)
        for (int num : arr) {
            System.out.println(num);
        }
    }

    //练习题
    @Test
    public void test3(){
        String[] arr=new String[]{"MM","MM","MM"};


        //方式一：普通forx循环
//        for (int i = 0; i <arr.length ; i++) {
//            arr[i]="GG";
//        }

        for (String s : arr) {
            s="GG";
        }

        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }

    }
}
