package com.tcmp.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

import java.util.Arrays;


public class TheLogger {
    private static final Logger log = Logger.getLogger(TheLogger.class);

    public void before(JoinPoint joinpoint) {
        log.info(">>>>>>>>>调用了：" + joinpoint.getTarget() + "类的" + joinpoint.getSignature().getName() + "方法，入参：" + Arrays.toString(joinpoint.getArgs()));

    }

    public void after(JoinPoint joinpoint,Object result){
        log.info(">>>>>>>>>调用了：" + joinpoint.getTarget() + "类的" + joinpoint.getSignature().getName() + "方法，返回："+result);
    }
}
