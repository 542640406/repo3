package com.tcmp.controller;

import com.github.pagehelper.PageInfo;
import com.tcmp.entity.Student;
import com.tcmp.service.StudentService;
import com.tcmp.vo.ScoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "queryStudent")
    public String queryStudent(Integer gender, Integer pageNum, Integer pageSize, Model model) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 5;
        }
        PageInfo<Student> pageInfo = studentService.queryStudentByGender(gender, pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("gender", gender);
        return "student_list";
    }

    @RequestMapping(value = "querySource")
    public String querySource(Integer pageNum, Integer pageSize, Model model) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 5;
        }
        System.out.println(pageNum);
        PageInfo<ScoreVo> pageInfo = studentService.query(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);

        return "student_source";
    }

    //查询详情
    @RequestMapping("queryById")
    public String queryById(Integer sid, Model model) {
        ScoreVo vo = studentService.queryById(sid);
        model.addAttribute("vo", vo);
        return "student_update";
    }

    //修改成绩Redirect
    @RequestMapping("updateSource")
    public String updateSource(Integer id, Integer score, Model model) {
        studentService.updateSource(id, score);
        return "redirect:querySource";
    }
    //删除成绩
    @ResponseBody
    @RequestMapping("delSource")
    public String delSource(Integer id){
        Integer result=studentService.delSource(id);
        System.out.println("================="+id);
        if(result>0){
            return "success";
        }
        return "error";
    }

}
