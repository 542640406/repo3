package com.tcmp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private Integer gradeId;
    private String studentName;
    private Integer gender;
    private Integer age;
    private String studentNum;
}
