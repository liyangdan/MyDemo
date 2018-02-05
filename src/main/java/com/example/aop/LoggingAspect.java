package com.example.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
/**
 * Created by liyangdan on 2018/2/4.
 */
@Component
@Aspect
public class LoggingAspect {

//    /**
//     * 前置通知：目标方法执行之前执行以下方法体的内容
//     * @param jp
//     */
//    @Before("execution(* com.example.service.UserServiceImpl.*(..))")
//    public void beforeMethod(JoinPoint jp){
//        String methodName = jp.getSignature().getName();
//        System.out.println("【前置通知】the method 【" + methodName + "】 begins with " + Arrays.asList(jp.getArgs()));
//    }
//
//    /**
//     * 返回通知：目标方法正常执行完毕时执行以下代码
//     * @param jp
//     * @param result
//     */
//    @AfterReturning(value="execution(* com.example.service.UserServiceImpl.*(..))",returning="result")
//    public void afterReturningMethod(JoinPoint jp, Object result){
//        String methodName = jp.getSignature().getName();
//        System.out.println("【返回通知】the method 【" + methodName + "】 ends with 【" + result + "】");
//    }
//
//    /**
//     * 后置通知：目标方法执行之后执行以下方法体的内容，不管是否发生异常。
//     * @param jp
//     */
//    @After("execution(* com.example.service.UserServiceImpl.*(..))")
//    public void afterMethod(JoinPoint jp){
//        System.out.println("【后置通知】this is a afterMethod advice...");
//    }
//
//    /**
//     * 异常通知：目标方法发生异常的时候执行以下代码
//     * 可以访问到异常对象，且可以指定在出现特定异常时在执行通知代码
//     *如下面Exception ex，若是指定为NullpointerException ex就不会执行通知代码
//     */
//    @AfterThrowing(value="execution(* com.example.service.UserServiceImpl.*(..))",throwing="e")
//    public void afterThorwingMethod(JoinPoint jp, Exception e){
//        String methodName = jp.getSignature().getName();
//        System.out.println("【异常通知】the method 【" + methodName + "】 occurs exception: " + e);
//    }



    /**
     //   * 环绕通知：目标方法执行前后分别执行一些代码，发生异常的时候执行另外一些代码
     //   * @return
     //   */
  @Around(value="execution(* com.example.controller.*.*(..))")
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
