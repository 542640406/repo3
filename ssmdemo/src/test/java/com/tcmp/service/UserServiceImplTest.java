package com.tcmp.service;

import com.tcmp.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceImplTest {
    @Autowired
    private UserService userService=null;
    @Test
    public void login() {
        User user=new User();
        user.setUserName("admin");
        user.setPassword("123");
        User user1=userService.login(user);
        System.out.println(user1!=null?"登录成功":"登录失败");
    }

    @Test
    public void save() {
        User user=new User();
        user.setUserName("张小小");
        user.setPassword("123456");
        user.setNickName("学生A");
        user.setMail("542640406@qq.com");
        user.setPic1Path("成功共和国");
        Integer result = userService.save(user);
        System.out.println(result > 0 ? "添加成功！" : "添加失败");
    }

    @Test
    public void queryById() {
        System.out.println(userService.queryById(174));
    }
}