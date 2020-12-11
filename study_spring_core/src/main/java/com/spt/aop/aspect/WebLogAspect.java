package com.spt.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Web层日志切面
 *
 * Spring AOP就是基于动态代理的，如果要代理的对象，实现了某个接口，那么Spring AOP会使用JDK Proxy，
 * 去创建代理对象，而对于没有实现接口的对象，就无法使用 JDK Proxy 去进行代理了，这时候Spring AOP会
 * 使用Cglib ，这时候Spring AOP会使用 Cglib 生成一个被代理对象的子类来作为代理。下面定义接口，代理
 * 对象即切点，和相关类
 *
 * @author 程序猿DD
 * @version 1.0.0
 * @date 16/5/17 上午10:42.
 * @blog http://blog.didispace.com
 */
@Aspect
@Order(5)//apsect1 和 aspect2 分别添加 @Order 注解,都是值越小的 aspect 越先执行
@Component
@Slf4j
public class WebLogAspect {

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    // 1)通过@Pointcut定义的切入点为com.spt.aop.web包下的所有函数（对web层所有请求处理做切入点）
    @Pointcut("execution(public * com.spt.aop.web..*.*(..))")
    public void webLog() {
    }

    // 2)然后通过@Before实现，对请求内容的日志记录（本文只是说明过程，可以根据需要调整内容)
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

    // 3)最后通过@AfterReturning记录请求返回的对象。
    @AfterReturning(returning = "ret" , pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("RESPONSE : " + ret);
        log.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
    }


}

