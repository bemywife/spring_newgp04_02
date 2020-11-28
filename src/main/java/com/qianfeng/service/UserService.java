package com.qianfeng.service;

import com.qianfeng.pojo.User;

public interface UserService {
    public Integer inserUser(User user);
    public User queryOne(Integer id);
}
