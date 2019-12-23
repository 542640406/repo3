package com.tcmp.dao;

import com.tcmp.entity.Gender;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GenderMapper {
    /*按照班级名称查询数据*/
    List<Gender> queryGenderByGenderName(@Param("gradeName")String gradeName);
    /*按照id查询详情*/
    Gender queryGradeById(@Param("id") Integer id);
    /*修改班级信息*/
    Integer update(Gender gender);
    /*删除班级*/
    Integer delete(@Param("id") Integer id);
    /*添加班级*/
    Integer save(Gender gender);
}
