package com.collection.day02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * 集合元素的遍历操作，使用迭代器Iterator接口
 *  1.内部方法：hasNext() 和 next()
 *  2.集合对象每次调用iterator()方法都会得到一个全新的迭代器对象
 *     默认游标都在集合的第一个元素之前。
 *
 *
 * @Author: start-spt
 * @Create: 2020/12/4 19:13
 */
public class IteratorTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();

        //方式一：
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        //报异常：NoSuchElementException
//        System.out.println(iterator.next());

        //方式二：不推荐
//        for (int i = 0; i <coll.size() ; i++) {
//            System.out.println(iterator.next());
//        }
        //方式三：推荐
        // hasNext():判断是否还有下一个元素
        while (iterator.hasNext()){
            // next(): ① 指针下移  ② 将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }

    }

    /**
     * iterator错误使用方式
     */
    @Test
    public void test2() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //错误方式一：
//        Iterator iterator = coll.iterator();
//        while (iterator.next() != null) {
//            System.out.println(iterator.next());
//        }
        /**
         * 456
         * Tom
         *
         * java.util.NoSuchElementException
         */


        //错误方式二：
        while (coll.iterator().hasNext()){
            System.out.println(coll.iterator().next());
        }
        /**
         * 123
         * 123
         * ·
         * ·
         * ·
         * 123
         *
         */

    }



}
