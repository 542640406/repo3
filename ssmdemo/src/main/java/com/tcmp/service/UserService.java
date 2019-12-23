package com.tcmp.service;

import com.github.pagehelper.PageInfo;
import com.tcmp.entity.User;

public interface UserService {
    User login(User user);
    PageInfo<User> queryAll(Integer pageNum,Integer pageSize);
    Integer save(User user);
    User queryById(Integer id);
}
