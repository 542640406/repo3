package com.tcmp.service;

import com.github.pagehelper.PageInfo;
import com.tcmp.entity.Gender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class GenderServiceImplTest {
    @Autowired
    private GenderService genderService;
    @Test
    public void queryGenderByGenderName() {
        String graderName="";
        PageInfo<Gender> genderPageInfo = genderService.queryGenderByGenderName(graderName, 1, 5);
        genderPageInfo.getList().forEach(gender -> System.out.println(gender));
    }

    @Test
    public void queryGradeById() {
        Integer id=11;
        Gender gender = genderService.queryGradeById(id);
        System.out.println(gender);
    }

    @Test
    public void update() {
        Gender gender=new Gender();
        gender.setId(11);
        gender.setGradeName("开挂班");
        gender.setDetails("一个开了挂的班级");
        Integer result=genderService.update(gender);
        System.out.println(result > 0 ? "修改成功！" : "修改失败");
    }

    @Test
    public void delete() {
        Integer delete = genderService.delete(109);
        System.out.println(delete > 0 ? "删除成功" : "删除失败！");
    }

    @Test
    public void save() {
        Gender gender=new Gender();
        gender.setGradeName("金剑队");
        gender.setDetails("来自火箭队的班级");

        Integer delete = genderService.save(gender);
        System.out.println(delete > 0 ? "添加成功" : "添加失败！");
    }
}