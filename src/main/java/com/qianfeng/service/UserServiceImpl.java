package com.qianfeng.service;

import com.qianfeng.pojo.User;

public class UserServiceImpl implements UserService {
    @Override
    public Integer inserUser(User user) {
//        System.out.println("额外功能");
        System.out.println("核心功能 in insert User");
        return 4;
    }

    @Override
    public User queryOne(Integer id) {
//        System.out.println("额外功能");
        System.out.println("核心功能 in query User");
        return new User();
    }


}
