package com.qianfeng;

import static org.junit.Assert.assertTrue;

import com.qianfeng.pojo.User;
import com.qianfeng.service.UserService;
import com.qianfeng.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * 测试jdk反射包中的 动态的代理类构建API
     */

    @Test
    public void shouldAnswerWithTrue() {
        //动态代理搭建
        //1.目标
        UserService userService = new UserServiceImpl();
        //2.额外功能
        InvocationHandler ih = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("额外功能gp_04_01");
                method.invoke(userService, args);//目标的方法，执行核心功能
                System.out.println("额外功能gp_04_02");

//                userService.queryOne();
                return null;
            }
        };

        //3.组装
        UserService proxy = (UserService) Proxy.newProxyInstance(AppTest.class.getClassLoader(), userService.getClass().getInterfaces(), ih);
        proxy.queryOne(1);
        System.out.println("==============");
        proxy.inserUser(new User());
    }

    @Test
    public void testDynamicProxy() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userServicePoxy = (UserService) context.getBean("userService2");
        userServicePoxy.queryOne(1);
        System.out.println("=====");
        userServicePoxy.inserUser(new User());
    }
}
