package com.collection.day02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @Author: start-spt
 * @Create: 2020/12/4 15:47
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection coll=new ArrayList();

        coll.add(123);//添加基本数据类型，其实添加的是装箱之后的包装类 int --> Integer
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        //1.contains(Object obj):判读当前集合中是否包含obj
        //在判断时会调用obj对象所在类的equals(),自定义的obj对象所在类要重写equals()
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom")));//true
        System.out.println(coll.contains(new Person("Jerry",20)));//false Person要重写equals()方法

        //2.containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合中。
        Collection coll1= Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1));

    }

    @Test
    public void test2(){
        Collection coll=new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //3.remove(Object obj):从当前集合中移除obj元素，返回值为boolean
        coll.remove(1234);
        System.out.println(coll);

        coll.remove(new Person("Jerry",20));
        System.out.println(coll);

        //4.removeAll(Collection coll1):差集：从当前集合中移除coll1中所有的元素。
        Collection coll1= Arrays.asList(123,4567);
        coll.removeAll(coll1);//removeAll()也会调用coll1中元素的equals()
        System.out.println(coll);
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //5.retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回当前集合coll
        Collection coll1= Arrays.asList(123,456,789);
        coll.retainAll(coll1);
        System.out.println(coll);
    }
    @Test
    public void test4() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        Collection coll1 = new ArrayList();

        coll1.add(123);
        coll1.add(456);
        coll1.add(new Person("Jerry", 20));
        coll1.add(new String("Tom"));
        coll1.add(false);

        System.out.println(coll.equals(coll1));

    }

    @Test
    public void test5() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        //7.集合-->数组 ：toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }

        //拓展：数组-->集合：调用Arrays的静态方法asList()
        List<String> list  = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List<int[]> arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1);//[[I@33833882] --> 此时会把“new int[]{123, 456}”看成一个整体

        List<Integer> arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2);//[123, 456]

        List<Integer> arr3 = Arrays.asList(123, 456);
        System.out.println(arr3);//[123, 456]

        //8.iterator():返回iterator接口的实例，用于遍历集合元素，放在Iterator

    }

}
