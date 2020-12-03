package com.spt.test.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spt.test.mybatisplus.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author: sptstart
 * @Create: 2020/12/2 23:12
 */


public interface UserService {

    // 插入一条记录（选择字段，策略插入）
    boolean save(User user);

    List<User> list();

    List<User> list(QueryWrapper<User> wrapper);

    boolean removeById(Long id);

    IPage<User> page(Page<User> page,  QueryWrapper<User> wrapper);

    void update(User user, Object o);

    //自定查询sql
    User getUserById(@Param("id") Long id);

}
