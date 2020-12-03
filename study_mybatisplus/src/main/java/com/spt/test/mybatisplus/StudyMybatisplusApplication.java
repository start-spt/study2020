package com.spt.test.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.spt.test.mybatisplus.mapper")
@SpringBootApplication
public class StudyMybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyMybatisplusApplication.class, args);
    }

}
