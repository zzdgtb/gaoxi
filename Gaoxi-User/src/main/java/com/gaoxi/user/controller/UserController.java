package com.gaoxi.user.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.gaoxi.config.LiveConstant;
import com.gaoxi.entity.user.UserEntity;
import com.gaoxi.model.user.vo.request.*;
import com.gaoxi.model.user.vo.response.ResultVO;
import com.gaoxi.service.sms.SmsService;
import com.gaoxi.service.user.UserService;
import com.gaoxi.utils.ApiErrorType;
import com.gaoxi.utils.LiveUrlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

    /**
     * 快捷登陆
     *
     * @param loginReq
     * @param httpRsp
     * @return
     */
    @GetMapping("/login")
    public ResultVO login(LoginReqVO loginReq, HttpServletResponse httpRsp) {

        // 登录鉴权
        UserEntity userEntity = userService.login(loginReq);

        return ResultVO.success(userEntity);
    }

    /**
     * 获取验证码
     *
     * @param verifyCodeVO
     * @param vResult
     * @return
     */
    @GetMapping("/getverifycode")
    public ResultVO getVerifyCode(@Valid VerifyCodeVO verifyCodeVO, BindingResult vResult) {
        if (vResult.hasErrors()) {
            return ResultVO.error(ApiErrorType.PARAMER_ERROR);
        }
        String verifycode = smsService.sendMsg(verifyCodeVO.getPhone());
        rdisTemplate.opsForValue().set(verifyCodeVO.getPhone() + "_verifycode", verifycode, 60, TimeUnit.SECONDS);
        logger.info("===============验证码:" + verifycode + "=====================");
        Map<String, Object> retMap = new HashMap<String, Object>();
        retMap.put("verifycode", verifycode);
        return ResultVO.success(retMap);

    }

    /**
     * 第三方授权登陆
     *
     * @param socialLoginVO
     * @param vResult
     * @return
     */
    @GetMapping("/sociallogin")
    public ResultVO socialLogin(SocialLoginVO socialLoginVO, BindingResult vResult) {
        if (vResult.hasErrors()) {
            return ResultVO.error(ApiErrorType.PARAMER_ERROR);
        }
        return null;
    }

    /**
     * 获取推流url
     *
     * @param getpushUrlVO
     * @param vResult
     * @return
     * @throws ParseException
     */
    @GetMapping("/getliveurl")
    public ResultVO getpushUrl(GetpushUrlVO getpushUrlVO, BindingResult vResult) throws ParseException {
        if (vResult.hasErrors()) {
            return ResultVO.error(ApiErrorType.PARAMER_ERROR);
        }
        String liveUrl = LiveUrlUtil.getPushUrl(LiveConstant.BIZ_ID, LiveConstant.LIVE_KEY, LiveConstant.BIZ_ID + "_"
                + getpushUrlVO.getUserid(), LiveConstant.DEFAULT_LIVE_TIME);
        logger.info("===============推流url:" + liveUrl + "=====================");
        Map<String, Object> retMap = new HashMap<String, Object>();
        retMap.put("liveUrl", liveUrl);
        return ResultVO.success(retMap);
    }

    /**
     * 获取直播播放url
     *
     * @param getplayUrlVO
     * @param vResult
     * @return
     * @throws ParseException
     */
    @GetMapping("/getplayurl")
    public ResultVO getplayUrl(GetplayUrlVO getplayUrlVO, BindingResult vResult) throws ParseException {
        if (vResult.hasErrors()) {
            return ResultVO.error(ApiErrorType.PARAMER_ERROR);
        }
        String playUrl = LiveUrlUtil.getFlvLiveUrl(LiveConstant.BIZ_ID, LiveConstant.BIZ_ID + "_"
                + getplayUrlVO.getUserid());
        logger.info("===============播放url:" + playUrl + "=====================");
        Map<String, Object> retMap = new HashMap<String, Object>();
        retMap.put("playUrl", playUrl);
        return ResultVO.success(retMap);
    }

}