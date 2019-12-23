package com.tcmp.service;

import com.github.pagehelper.PageInfo;
import com.tcmp.entity.Student;
import com.tcmp.vo.ScoreVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentServiceImplTest {
    @Autowired
    private StudentService studentService;
    @Test
    public void queryStuentByGender() {
        Integer pageNum=1;//总页数
        Integer pageSize=5;//页面大小

        PageInfo<Student> pageInfo=studentService.queryStudentByGender(1,pageNum,pageSize);
        System.out.println("===============第"+pageNum+"页=================");
        List<Student> list=pageInfo.getList();
        list.forEach(student -> System.out.println(student));
        System.out.println("当前是"+pageNum);
        System.out.println("共"+ pageInfo.getPages()+"页");
        System.out.println("共"+pageInfo.getTotal()+"条数据");
    }


    @Test
    public void query() {
        studentService.query(1, 3).getList().forEach(scoreVo -> System.out.println(scoreVo));

    }

    @Test
    public void queryById() {
        System.out.println(studentService.queryById(4));
    }

    @Test
    public void updateSource() {
        Integer result=studentService.updateSource(1,60);
        System.out.println(result > 0 ? "修改成功！" : "修改失败");
    }

    @Test
    public void delSource() {
        Integer result=studentService.delSource(3);
        System.out.println(result > 0 ? "删除成功！" : "失败");
    }
}