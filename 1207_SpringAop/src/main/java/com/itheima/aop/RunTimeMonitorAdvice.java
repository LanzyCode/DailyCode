package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RunTimeMonitorAdvice {
    //切入点
    @Pointcut("execution(* com.itheima.service.*Service.find(..))")
    public void pt(){

    }
    @Around("pt()")
    public Object runtimeAround(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        System.out.println(signature.getDeclaringTypeName());
        System.out.println(signature.getName());
        long startTime=System.currentTimeMillis();
        Object ret = pjp.proceed();
        long endTime=System.currentTimeMillis();
        System.out.println(endTime - startTime);
        return ret;
    }
}
