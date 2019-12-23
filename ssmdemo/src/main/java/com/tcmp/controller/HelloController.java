package com.tcmp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("toTop")
    public String toTop(){
        return "toTop";
    }
    @RequestMapping("toLeft")
    public String toLeft(){
        return "toLeft";
    }
    @RequestMapping("toMain")
    public String toMain(){
        return "toMain";
    }
}
