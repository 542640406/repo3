package com.tcmp.controller;

import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.IMPDEP1;
import com.tcmp.entity.Gender;
import com.tcmp.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;

@Controller
@RequestMapping("gender")
public class GenderController {
    @Autowired
    private GenderService genderService;

    @RequestMapping(value = "toList")
    public String query(String gradeName, Model model, Integer pageNum, Integer pageSize) {
        if (null==pageNum) {
            pageNum = 1;
        }
        if (null==pageSize) {
            pageSize = 5;
        }
        PageInfo<Gender> genderPageInfo = genderService.queryGenderByGenderName(gradeName, pageNum, pageSize);
        model.addAttribute("pageInfo", genderPageInfo);
        model.addAttribute("gradeName", gradeName);
        return "grade_list";
    }
    /*查询详情*/
    @RequestMapping("queryGradeById")
    public String queryById(Integer id,String open,Model model){
        Gender grade = genderService.queryGradeById(id);
        model.addAttribute("grade",grade);
        if(open.equals("update")){
            return "grade_update";
        }
            return "grade_show";
    }
    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(Gender grade, HttpServletRequest request){
        String name = request.getParameter("gradeName");
        System.out.println(name);
        Integer count=genderService.update(grade);
        System.out.println(count);
        if(count>0){
            return "success";
        }
        return "error";
    }
    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public String delete(Integer id, HttpServletRequest request){
        Integer count=genderService.delete(id);
        System.out.println(count);
        if(count>0){
            return "success";
        }
        return "error";
    }
    @RequestMapping("toSave")
    public String toSave(){
        return "grade_save";
    }
    @ResponseBody
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(Gender gender,Model model){

        Integer result = genderService.save(gender);
        System.out.println(result > 0 ? "添加成功" : "添加失败！");
        if(result>0){
            return "success";
        }
        return "error";
    }
}
