package com.gaoxi.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaoxi.entity.user.UserEntity;
import com.gaoxi.model.user.vo.request.LoginReqVO;
import com.gaoxi.service.user.UserService;

/**
 * Created by admin on 2018/9/25.
 */
@RestController
public class TestController {
	@Autowired
	private UserService userService;
    @GetMapping("/hello")
    public String index(){
        return "hello world!!!";
    }
    @GetMapping("/logintest")
    public UserEntity loginTest(){
        return userService.login(new LoginReqVO("张三","123"));
    }
}
