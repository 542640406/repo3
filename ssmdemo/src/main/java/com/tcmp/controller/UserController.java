package com.tcmp.controller;

import com.github.pagehelper.PageInfo;
import com.tcmp.dao.UserMapper;
import com.tcmp.entity.User;
import com.tcmp.service.UserService;
import com.tcmp.util.Common;
import com.tcmp.util.UploadUtil;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("toSave")
    public String toSave() {
        return "user_saves";
    }

    /*查询用户*/
    @RequestMapping(value = "queryAll")
    public String queryAll(Integer pageNum, Integer pageSize, Model model) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 5;
        }
        System.out.println(pageNum);
        PageInfo<User> pageInfo = userService.queryAll(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);

        return "user_list";
    }

    @RequestMapping(value = "loginUser", method = RequestMethod.POST)
    public String login(User user, HttpSession session, Model model) {
        User loginUser = userService.login(user);
        log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<调用了登录方法>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + loginUser.getUserName());
        if (null != loginUser) {
            //把用户对象放到session中
            session.setAttribute(Common.LOGIN_USER, loginUser);
            log.info("返回值welcome");
            return "welcome";
        }

        model.addAttribute("message", "用户名或密码错误");
        return "login";
    }

    @RequestMapping("logOut")
    public String logout(HttpSession session) {
        //对出移除用户对象
        session.removeAttribute(Common.LOGIN_USER);
        return "login";
    }

    @ExceptionHandler(value = {RuntimeException.class})
    public String handlerException(RuntimeException e, HttpServletRequest request) {
        request.setAttribute("e", e);
        return "error";
    }

    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    public String saveUser(MultipartFile pic, HttpServletRequest request, User user) {
        String saveFileName = "";
        //判断文件加是否为空；
        System.out.println("+1+1+1+1+1+1+1+1+1+1+" + pic.isEmpty());
        if (!pic.isEmpty()) {
            //文件上传路径
            String path = request.getSession().getServletContext().getRealPath("statics" + File.separator + "uploadfiles");
            //源文件名
            String oldFileName = pic.getOriginalFilename();
            //源文件名后缀
            String prefix = oldFileName.substring(oldFileName.lastIndexOf("."));
            //判断文件大小
            int fileSize = 500000;
            if (pic.getSize() > fileSize) {
                request.setAttribute("errorInfo", "* 上传文件大小不得超过500KB");
                return "user_save";
            }
            //判断文件格式
            System.out.println("11111111111111111111111111" + prefix);
            if (prefix.equalsIgnoreCase(".jpg") || prefix.equalsIgnoreCase(".png") || prefix.equalsIgnoreCase(".jpeg")) {
                saveFileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + prefix;
                System.out.println("》》》》》》》》》进入了：" + prefix);
                //设置用户的头像文件名称属性值
                user.setPic1Path(saveFileName);
                File targetFile = new File(path, saveFileName);
                //判断是否有该文件如果没有就创建一个
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                //保存
                //写入但磁盘
                try {
                    pic.transferTo(targetFile);
                    //用户信息保存
                    userService.save(user);
                    System.out.println("保存图片完成===========：" + path + saveFileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                request.setAttribute("errorInfo", "* 上传文件格式不正确，不支持" + prefix + "格式文件上传");
                return "user_save";
            }
        }
        return "redirect:/user/queryAll";
    }

    @RequestMapping(value = "queryById")
    public String queryById(Integer id, Model model) {
        User user = userService.queryById(id);
        model.addAttribute("user", user);
        System.out.println(user.getPic1Path());
        System.out.println(user.getPic2Path());
        return "user_detail";
    }

    @RequestMapping(value = "saveUser2" ,method = RequestMethod.POST)
    public String saveUser2(User user, HttpServletRequest request,
     MultipartFile pic1,MultipartFile pic2) {
       //文件上传路径
        String path=request.getSession().getServletContext().getRealPath("statics"+File.separator+"uploadfiles");
        try {
            user.setPic1Path(UploadUtil.upload(pic1,path));
            System.out.println("用户照片保存成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            user.setPic2Path(UploadUtil.upload(pic2,path));
            System.out.println("证件照片保存成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        userService.save(user);
        return "redirect:/user/queryAll";
    }
}
