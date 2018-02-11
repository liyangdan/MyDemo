package com.example.dem.aop;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by liyangdan on 2018/2/10.
 */
@Component
@Aspect
public class LoggingAspect {
    /**
     //   * 环绕通知：目标方法执行前后分别执行一些代码，发生异常的时候执行另外一些代码
     //   * @return
     //   */
    @Around(value="execution(* com.example.dem.controller.*.*(..))")
    public Object aroundMethod(ProceedingJoinPoint jp){
        String methodName = jp.getSignature().getName();
        Object result = null;
        try {
            System.out.println("【环绕通知中的--->前置通知】：the method 【" + methodName + "】 begins with " + Arrays.asList(jp.getArgs()));
            //执行目标方法
            result = jp.proceed();
            System.out.println("【环绕通知中的--->返回通知】：the method 【" + methodName + "】 ends with " + result);
        } catch (Throwable e) {
            System.out.println("【环绕通知中的--->异常通知】：the method 【" + methodName + "】 occurs exception " + e);
        }

        System.out.println("【环绕通知中的--->后置通知】：-----------------end.----------------------");
        return result;
    }
}
