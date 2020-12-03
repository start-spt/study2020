package com.startspt.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections：操作Collections、Map的工具类。
 *
 * 面试题：Collection 和 Collections的区别？
 *      1.Collection:
 *          是集合类的上层接口。本身是一个Interface，里面包含了一些集合的基本操作。
 *          Collection接口时Set接口和List接口的父接口
 *      2.Collections
 *          Collections是一个集合框架的帮助类，里面包含一些对集合的排序，搜索以及序列化的操作。
 * 常用方法：
 *      排序操作：
 *          reverse(List):反转List中元素的顺序
 *          shuffle(List):对List集合元素进行随机排序
 *          sort(List):根据元素的自然顺序对指定List集合元素按升序排序
 *          sort(List,Comparator):根据指定的Comparator产生的顺序对List集合元素进行排序
 *          swap(List,int,int):将指定的List集合中的 i 处元素和 j 处元素进行交换
 *
 *      查找。替换操作：
 *          Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
 *          Object max(Collection，Comparator)：根据Comparator指定的顺序，返回给定集合中的最大元素
 *          Object min(Collection)：根据元素的自然顺序，返回给定集合中的最小元素
 *          Object min(Collection，Comparator)：根据Comparator指定的顺序，返回给定集合中的最小元素
 *          frequency(Collection Object o)：返回指定集合中指定元素出现的次数
 *          copy(List dest,List src)：将集合src中的元素全部复制到dest中,并且覆盖相应索引的元素
 *          replaceAll(List list,Object old,Object new)：替换批定元素为某元素,若要替换的值存在刚返回true,反之返回false
 *
 *
 *
 * @Author: sptstart
 * @Create: 2020/12/1 14:58
 */
public class CollectionsTest {

    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(1123);
        list.add(1156);
        list.add(1134);
        list.add(1134);
        list.add(1134);

        //报异常：
        // List dest = new ArrayList();
        //  Collections.copy(dest,list);
        //IndexOutOfBoundsException("Source does not fit in dest")


//        List dest = new ArrayList();
//        dest.add(123);
//        dest.add(123);
//        dest.add(123);
//        dest.add(123);
//        dest.add(123);
//        dest.add(123);

        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);

        System.out.println(dest);

        /**
         * Collections 类中提供了多个 synchronizedXxx() 方法
         * 该方法可将指定集合包装成线程同步的集合，从而可以解决
         * 多线程并发访问集合时的线程安全问题
         */

        //返回的list1即为线程安全的List
        List list1 = Collections.synchronizedList(list);

    }

    @Test
    public void test1(){

        List list = new ArrayList();
        list.add(123);
        list.add(56);
        list.add(34);
        list.add(34);
        list.add(34);
        list.add(-96);
        list.add(89);

        System.out.println(list);
        //Collections.reverse(list);
        //Collections.shuffle(list);
        //Collections.sort(list);
        //Collections.swap(list,1,2);
        System.out.println(list);

        System.out.println(Collections.frequency(list,34));


    }

}
