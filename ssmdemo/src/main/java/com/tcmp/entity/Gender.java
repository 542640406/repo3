package com.tcmp.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Gender {
    private Integer id;
    private String gradeName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    private String details;
}
