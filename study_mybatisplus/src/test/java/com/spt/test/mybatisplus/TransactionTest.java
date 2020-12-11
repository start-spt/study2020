package com.spt.test.mybatisplus;

import com.spt.test.mybatisplus.entity.User;
import com.spt.test.mybatisplus.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @Author: start-spt
 * @Create: 2020/12/10 22:42
 */
@SpringBootTest
public class TransactionTest {
    @Autowired
    SqlSessionFactory factory;

    @Test
    @Transactional
    public void writeTest(){
        SqlSession session = factory.openSession();
        UserMapper userDao = session.getMapper(UserMapper.class);

        //事务一：写
        User user1 = new User();
        user1.setId(4L);
        user1.setName("更新用户");
        user1.setEmail("更新邮箱");
        userDao.updateUser(user1);
        try {
            TimeUnit.SECONDS.sleep(120);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //准备报错，触发事务回滚
        int zero = 1 / 0;
    }

    @Test
    public void readTest(){
        SqlSession session = factory.openSession();
        UserMapper userDao = session.getMapper(UserMapper.class);

        //事务二：读
        User user2 = userDao.findById(4);
        System.out.println("读的内容："+user2);
    }
}
