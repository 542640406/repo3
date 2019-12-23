package com.tcmp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tcmp.dao.StudentMapper;
import com.tcmp.entity.Student;
import com.tcmp.vo.ScoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentMapper studentMapper;
    private Integer sid;

    @Override
    public PageInfo<Student> queryStudentByGender(Integer gender, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Student> list=studentMapper.queryStudentByGender(gender);
        PageInfo<Student> pageInfo=new PageInfo<>(list);

        return pageInfo;
    }

    @Override
    public PageInfo<ScoreVo> query(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ScoreVo> query = studentMapper.query();
        PageInfo<ScoreVo> pageInfo=new PageInfo<>(query);
        return pageInfo;
    }

    @Override
    public ScoreVo queryById(Integer sid) {
        this.sid = sid;
        return studentMapper.queryById(sid);
    }

    @Override
    public Integer updateSource(Integer id, Integer score) {
        return studentMapper.updateSource(score,id);
    }

    @Override
    public Integer delSource(Integer id) {
        return studentMapper.delSource(id);
    }
}
