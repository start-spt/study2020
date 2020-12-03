package com.spt.test.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spt.test.mybatisplus.entity.User;
import com.spt.test.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Map;

@SpringBootTest
class TestMybatisPlusApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void testUpdate() {
        User user = new User();
        user.setName("tom");
        user.setAge(20);
        user.setEmail("tom@163.com");
        // 手动添加数据
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        if (userService.save(user)) {
            userService.list().forEach(System.out::println);
        } else {
            System.out.println("添加数据失败");
        }
    }

    /**
     * 自动填充功能
     */
    @Test
    public void testAutoFill() {
        User user = new User();
        user.setName("tom");
        user.setAge(20);
        user.setEmail("tom@163.com");
        if (userService.save(user)) {
            userService.list().forEach(System.out::println);
        } else {
            System.out.println("添加数据失败");
        }
    }
    /**
     * 逻辑删除
     */
    @Test
    public void testDelete() {
        if (userService.removeById(1334415049032245249L)) {
            System.out.println("删除数据成功");
            userService.list().forEach(System.out::println);
        } else {
            System.out.println("删除数据失败");
        }
    }

    /**
     * 分页插件的使用
     */
    @Test
    public void testPage() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.ge("age",26);
        Page<User> page = new Page<>(1, 2);
        IPage<User> userIPage = userService.page(page, wrapper);
        System.out.println("总条数"+userIPage.getTotal());
        System.out.println("总页数"+userIPage.getPages());
    }

    /**
     * mybatis-plus 代码实现乐观锁
     */
    @Test
    public void testVersion() {
        User user = new User();
        user.setName("tom");
        user.setAge(20);
        user.setEmail("tom@163.com");
        userService.save(user);
        userService.list().forEach(System.out::println);
        user.setName("jarry");
        userService.update(user, null);
        userService.list().forEach(System.out::println);
    }

    @Test
    public void testQueryWrapper() {
        // Step1：创建一个 QueryWrapper 对象
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        // Step2： 构造查询条件
        queryWrapper
                .select("id", "name", "age")
                .gt("age", 20)
                .like("name", "j");

        // Step3：执行查询
        userService
                .list(queryWrapper)
                .forEach(System.out::println);
    }
    @Test
    public void getUserById() {
        System.out.println(userService.getUserById(1L));
    }
}