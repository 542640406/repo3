package com.tcmp.service;

import com.github.pagehelper.PageInfo;
import com.tcmp.entity.Student;
import com.tcmp.vo.ScoreVo;

import java.util.List;

public interface StudentService {
    PageInfo<Student> queryStudentByGender(Integer gender, Integer pageNum, Integer pageSize);
    PageInfo<ScoreVo> query(Integer pageNum,Integer pageSize);
    ScoreVo queryById(Integer sid);
    Integer updateSource(Integer id,Integer score);
    Integer delSource(Integer id);
}
