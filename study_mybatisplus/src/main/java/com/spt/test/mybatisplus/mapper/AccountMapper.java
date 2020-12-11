package com.spt.test.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spt.test.mybatisplus.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by ${HeJD} on 2018/6/27.
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
    Account getOneAccount(@Param("id") int id);
    //@Param是MyBatis所提供的(org.apache.ibatis.annotations.Param)，作为Dao层的注解，
    // 作用是用于传递参数，从而可以与SQL中的的字段名相对应，一般在2=<参数数<=5时使用最佳。

    void save(Account account);


}