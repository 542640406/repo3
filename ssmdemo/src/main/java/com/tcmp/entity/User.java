package com.tcmp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private String nickName;
    private String password;
    private String pic1Path;
    private String pic2Path;
    private String mail;
}
