package com.gaoxi.user.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gaoxi.entity.user.UserEntity;
import com.gaoxi.model.user.vo.request.LoginReqVO;
import com.gaoxi.model.user.vo.request.VerifyCodeVO;
import com.gaoxi.model.user.vo.response.ResultVO;
import com.gaoxi.service.sms.SmsService;
import com.gaoxi.service.user.UserService;
import com.gaoxi.utils.ApiErrorType;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
    @Autowired
    private UserService userService;
    
	@Resource
    private RedisTemplate<String, String> rdisTemplate;
    
    @Reference(version = "1.0.0")
    private SmsService smsService;
    
    
    
   @GetMapping("/login")
    public ResultVO login(LoginReqVO loginReq, HttpServletResponse httpRsp) {

        // 登录鉴权
        UserEntity userEntity = userService.login(loginReq);
        
        return ResultVO.success(userEntity);
    }
   @GetMapping("/getverifycode")
   public ResultVO getVerifyCode(@Valid VerifyCodeVO verifyCodeVO,BindingResult vResult){
	   if(vResult.hasErrors()){
		   return ResultVO.error(ApiErrorType.PARAMER_ERROR);
	   }
	   String verifycode = smsService.sendMsg(verifyCodeVO.getPhone());
	   rdisTemplate.opsForValue().set(verifyCodeVO.getPhone()+"_verifycode", verifycode,60,TimeUnit.SECONDS);
	   logger.info("===============验证码:"+verifycode+"=====================");
	   Map<String,Object> retMap = new HashMap<String,Object>();
	   retMap.put("verifycode", verifycode);
	   return ResultVO.success(retMap);
	   
   }
}