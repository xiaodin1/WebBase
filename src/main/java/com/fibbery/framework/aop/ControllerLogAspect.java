package com.fibbery.framework.aop;

import com.fibbery.framework.aop.annotation.ControllerLog;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
/**
 * 记录controller的操作日志的
 * Created by Administrator on 2016/7/29.
 */
@Aspect
@Component
public class ControllerLogAspect {

    private static Logger logger = Logger.getLogger(ControllerLog.class);

    @Pointcut("@annotation(com.fibbery.framework.aop.annotation.ControllerLog)")
    public void controllerLogAspect(){}

    @AfterReturning(pointcut = "controllerLogAspect()")
    public void afterReturning(JoinPoint joinPoint) {
        handlerLog(joinPoint, null);
    }


    @AfterThrowing(pointcut = "controllerLogAspect()")
    public void afterThrowing(JoinPoint joinPoint,Exception e) {
        handlerLog(joinPoint, e);
    }

    private void handlerLog(JoinPoint joinPoint, Exception e) {

    }
}
