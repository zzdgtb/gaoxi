package com.gaoxi.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gaoxi.entity.user.UserEntity;
import com.gaoxi.model.user.vo.request.LoginReqVO;
import com.gaoxi.model.user.vo.response.ResultVO;
import com.gaoxi.service.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference(version = "1.0.0")
    private UserService userService;

    @GetMapping("/login")
    public ResultVO login(LoginReqVO loginReq, HttpServletResponse httpRsp) {

        // 登录鉴权
        UserEntity userEntity = userService.login(loginReq);

        return ResultVO.success(userEntity);
    }
}