package com.spt.test.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spt.test.mybatisplus.entity.User;
import com.spt.test.mybatisplus.mapper.UserMapper;
import com.spt.test.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: sptstart
 * @Create: 2020/12/2 23:13
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean save(User user) {
        int insert = userMapper.insert(user);
        if (insert>0){
            return true;
        }
        return false;
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> list() {
        List<User> userList = userMapper.selectList(null);
        return userList;
    }

    @Override
    public List<User> list(QueryWrapper<User> wrapper) {
        List<User> userList = userMapper.selectList(wrapper);
        return userList;
    }

    @Override
    public boolean removeById(Long id) {
        int delete = userMapper.deleteById(id);
        if (delete>0){
            return true;
        }
        return false;
    }

    @Override
    public  IPage<User> page(Page<User> page, QueryWrapper<User> wrapper) {
        IPage<User> userIPage = userMapper.selectPage(page, wrapper);
        return  userIPage;
    }

    @Override
    public void update(User user, Object o) {
        userMapper.update(user,null);
    }

}
