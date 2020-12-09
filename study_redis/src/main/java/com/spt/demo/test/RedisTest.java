package com.spt.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author: start-spt
 * @Create: 2020/12/8 18:43
 */
public class RedisTest {
    @Test
    public void testJedis() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("info", "hello,redis.");
        System.out.println(jedis.get("info"));
        jedis.close();
    }

    //jedis连接池
    @Test
    public void testJedisPool() throws Exception {
        //创建一个数据库连接池对象（单例），需要指定服务的ip和端口号
        JedisPool jedisPool = new JedisPool("127.0.0.1", 6379);
        //从连接池中获得连接
        Jedis jedis = jedisPool.getResource();
        //使用Jedis操作数据库（方法级别使用）
        String result = jedis.get("info");
        System.out.println(result);
        //一定要关闭Jedis连接
        jedis.close();
        //系统关闭前关闭连接池
        jedisPool.close();
    }

    @Test
    public void testJedisClientPool() {
        // 初始化spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-redis.xml");
        // 从容器中获取对象
        JedisPool jedisPool = context.getBean("jedisPool", JedisPool.class);
        Jedis jedis = jedisPool.getResource();
        jedis.set("123", "1234");
        System.out.println(jedis.get("123"));
    }
}
