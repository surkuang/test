package com.fpi.test.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 切面日志记录类
 *
 * @author ZengShuo
 * @since 2020/12/24
 */
@Aspect
@Component
@Slf4j
public class RestOperationLog {

    @Pointcut("execution(public * com.fpi.test.api..*.*(..))")
    private void operationPointCut(){}

    @Around("operationPointCut()")
    public Object around(ProceedingJoinPoint joinPoint){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 获取HttpServletRequest的api
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        log.info("api调用,Method:{},url:{},参数：{}",request.getMethod(),request.getRequestURL(),joinPoint.getArgs());
        Object proceed = null;
        try {
            // 执行切点方法
            proceed =  joinPoint.proceed(joinPoint.getArgs());
        } catch (Throwable throwable) {
            log.error("api异常调用：",throwable);
        }
        return proceed;
    }

}
