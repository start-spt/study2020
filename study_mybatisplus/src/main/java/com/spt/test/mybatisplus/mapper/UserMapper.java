package com.spt.test.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spt.test.mybatisplus.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User getUserById(@Param("id") Long id);

    /************缓存测试****************/
    /**
     * 查询所有的用户
     * @return
     */
    List<User> findAll();
    /**
     * 根据Id查询用户
     * @return
     */
    User findById(Integer id);
    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

}