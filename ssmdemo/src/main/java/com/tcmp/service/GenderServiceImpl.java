package com.tcmp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tcmp.dao.GenderMapper;
import com.tcmp.dao.StudentMapper;
import com.tcmp.entity.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("genderService")
public class GenderServiceImpl implements GenderService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private GenderMapper genderMapper;
    @Override
    public PageInfo<Gender> queryGenderByGenderName(String gradeName,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Gender> genderList = genderMapper.queryGenderByGenderName(gradeName);
        PageInfo<Gender> pageInfo= new PageInfo<>(genderList);
        return pageInfo;
    }

    @Override
    public Gender queryGradeById(Integer id) {
        return genderMapper.queryGradeById(id);
    }

    @Override
    public Integer update(Gender gender) {
        return genderMapper.update(gender);
    }

    /**
     * 删除班级
     * @param id 班级id
     * @return
     */
    @Override
    public Integer delete(Integer id) {
        studentMapper.delete(id);
        return genderMapper.delete(id);
    }

    @Override
    public Integer save(Gender gender) {
        return genderMapper.save(gender);
    }
}
