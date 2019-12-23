package com.tcmp.service;

import com.github.pagehelper.PageInfo;
import com.tcmp.entity.Gender;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GenderService {
    /*按照班级名称查询数据*/
    PageInfo<Gender> queryGenderByGenderName(String gradeName, Integer pageNum, Integer pageSize);
    /*按照id查询班级像情感*/
    Gender queryGradeById(Integer id);
    /*修改*/
    Integer update(Gender gender);
    /*删除*/
    Integer delete(Integer id);
    /*添加*/
    Integer save(Gender gender);
}
