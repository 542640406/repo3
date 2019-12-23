package com.tcmp.dao;

import com.tcmp.entity.User;

import java.util.List;

public interface UserMapper {
    User login(User user);
    List<User> queryAll();
    Integer save(User user);
    User queryById(Integer id);
}
