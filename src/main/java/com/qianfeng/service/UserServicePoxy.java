package com.qianfeng.service;

import com.qianfeng.pojo.User;

/**
 * 代替UserService 代理额外功能
 * 静态代理类：
 *  1.要和目标保持功能一致：和目标保持同一套接口
 *  2.组成：目标+额外功能
 */
public class UserServicePoxy implements UserService{
    private UserService userService = new UserServiceImpl();

    public Integer inserUser(User user) {
        System.out.println("额外功能");
        return userService.inserUser(user);
    }

    public User queryOne(Integer id) {
        System.out.println("额外功能");
        return userService.queryOne(id);
    }
}
