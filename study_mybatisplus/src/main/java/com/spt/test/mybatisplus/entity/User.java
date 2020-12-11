package com.spt.test.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

//@Data
@Getter
@Setter
public class User implements Serializable {
//    @TableId(type=IdType.ASSIGN_ID)
    private Long id;
//    @TableField(fill = FieldFill.INSERT)
    private String name;
//    @TableField(fill = FieldFill.INSERT)
    private int age;
//    @TableField(fill = FieldFill.INSERT)
    private String email;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 最后修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * 逻辑删除（0 未删除、1 删除）
     */
    @TableLogic(value = "0", delval = "1")
    @TableField(fill = FieldFill.INSERT)
    private Integer deleteFlag;
    /**
     * 版本号（用于乐观锁， 默认为 1）
     */
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleteFlag=" + deleteFlag +
                ", version=" + version +
                '}';
    }
}