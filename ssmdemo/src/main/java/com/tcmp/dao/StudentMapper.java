package com.tcmp.dao;

import com.tcmp.entity.Student;
import com.tcmp.vo.ScoreVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    List<Student> queryStudentByGender(@Param("gender") Integer gender);
    @Delete("DELETE FROM tcmp.student WHERE grade_id=#{id}")
    Integer delete(Integer id);

    List<ScoreVo> query();
    //查询详情
    ScoreVo queryById(Integer sid);
    /*修改成绩*/
    Integer updateSource(@Param("score") Integer score,@Param("id") Integer id);
    //删除成绩
    Integer delSource(@Param("id") Integer id);

}
