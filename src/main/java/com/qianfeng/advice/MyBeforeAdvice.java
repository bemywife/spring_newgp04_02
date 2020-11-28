package com.qianfeng.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 前置额外功能
 */
public class MyBeforeAdvice implements MethodBeforeAdvice {
    /**
     * 主体逻辑，在核心功能之前执行
     *
     * @param method 当前执行的方法
     * @param args   方法参数
     * @param target 目标对象
     * @throws Throwable
     */
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Before-----,method" + method.getName() + " args:" + args.length + " target:  " + target);
    }
}
