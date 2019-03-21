package com.ganzihong.hodgepodge.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @author ganzh
 * @description
 * @date 2019/1/13
 */
@Aspect
@Component
public class LogAspect {
    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.ganzihong.hodgepodge.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        //String requestId = String.valueOf(UUID.randomUUID());
        //MDC.put("requestId",requestId);
        logger.info("url={},method={},ip={}", request.getRequestURI(), request.getMethod(), request.getRemoteAddr());
        logger.info("class_method={},request={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(), JSON.toJSONString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterRunning(Object object) {
        logger.info("response={}", JSON.toJSONString(object));
        //MDC.clear();
    }
}
