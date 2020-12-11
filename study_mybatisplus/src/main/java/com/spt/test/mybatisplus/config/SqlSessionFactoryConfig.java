//package com.spt.test.mybatisplus.config;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import javax.sql.DataSource;
//import java.io.IOException;
//
//@Configuration
//public class SqlSessionFactoryConfig {
//
//	@Autowired
//	DataSource dataSource;
//
//	@Bean
//	@Primary
//	public SqlSessionFactory sqlSession() {
//		SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
//		try {
//			sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));//设置对应的xml文件地址
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		sqlSessionFactoryBean.setDataSource(dataSource);
//		SqlSessionFactory factory=null;
//		try {
//			factory = sqlSessionFactoryBean.getObject();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return factory;
//	}
//}