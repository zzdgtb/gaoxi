package com.gaoxi.controller.user;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gaoxi.base.http.LoginReq;
import com.gaoxi.base.http.Result;
import com.gaoxi.entity.user.UserEntity;
import com.gaoxi.service.user.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference(version = "1.0.0")
    private UserService userService;
    
   @GetMapping("/login")
    public Result login(LoginReq loginReq, HttpServletResponse httpRsp) {

        // 登录鉴权
        UserEntity userEntity = userService.login(loginReq);
        
        return Result.success(userEntity);
    }
}