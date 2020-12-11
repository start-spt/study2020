package com.spt.test.mybatisplus;

import com.spt.test.mybatisplus.entity.User;
import com.spt.test.mybatisplus.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * 缓存的作用：
 *      使用缓存是为了减少和数据库的交互次数，提高执行效率。
 *
 * mybatis的缓存：
 *      一级缓存：
 *          一级缓存是SqlSession级别的缓存，一级缓存缓存的是对象，当SqlSession提交、关闭以及其他的更新数据库的操作发生后，
 *          一级缓存就会清空。二级缓存是SqlSessionFactory级别的缓存，同一个SqlSessionFactory产生的SqlSession都共享一个
 *      二级缓存：
 *          二级缓存中存储的是数据，当命中二级缓存时，通过存储的数据构造对象返回。
 *
 *  查询数据的时候，查询的流程是二级缓存>一级缓存>数据库。
 *
 *
 * @Author: start-spt
 * @Create: 2020/12/10 19:21
 */
@SpringBootTest
public class CacheTest {
    @Autowired
    SqlSessionFactory factory;

    @Test
    public void findByIdTest(){
        SqlSession session = factory.openSession();
        UserMapper userDao = session.getMapper(UserMapper.class);
        //第一次获取该用户
        User user1 = userDao.findById(4);
        System.out.println(user1);
        //第二次获取该用户
        User user2 = userDao.findById(4);
        System.out.println(user2);
        System.out.println(user1 == user2);
        session.close();
    }

    //对SqlSession进行清除缓存的操作，即清楚一级缓存，然后再次进行测试
    @Test
    public void findByIdTest2(){
        SqlSession session = factory.openSession();
        UserMapper userDao = session.getMapper(UserMapper.class);
        User user1 = userDao.findById(4);
        System.out.println(user1);
        //       session.commit(); 调用SqlSession的commit方法清空缓存

        user1.setName("更新用户");
        user1.setEmail("更新邮箱");
        userDao.updateUser(user1);//通过更新SqlSession清空缓存
        User user2 = userDao.findById(4);
        System.out.println(user2);
        System.out.println(user1 == user2);
        session.close();
    }

    //开启二级缓存测试
    @Test
    public void findByIdTest3(){
        //第一次查询 并更新二级缓存
        SqlSession session1 = factory.openSession();
        UserMapper userDao1 = session1.getMapper(UserMapper.class);
        User user1 = userDao1.findById(4);
        System.out.println(user1);
        session1.commit(); //commit()方法提交二级缓存 同时清空一级缓存
        session1.close();//

        //user1.setName("更新用户");
        //user1.setEmail("更新邮箱");
        //userDao.updateUser(user1);//通过更新SqlSession清空缓存
        //第二次查找命中二级缓存
        SqlSession session2 = factory.openSession();
        UserMapper userDao2 = session2.getMapper(UserMapper.class);
        User user2 = userDao2.findById(4);
        session2.commit(); //commit()方法提交二级缓存 同时清空一级缓存
        session2.close();//
        System.out.println(user2);
        System.out.println(user1 == user2);
    }
}
