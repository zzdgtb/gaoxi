package com.gaoxi.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gaoxi.entity.user.UserEntity;
import com.gaoxi.exception.BusinessException;
import com.gaoxi.mapper.UserMapper;
import com.gaoxi.model.user.vo.request.LoginReqVO;
import com.gaoxi.service.base.AbstractBaseService;
import com.gaoxi.service.user.UserService;
import org.springframework.data.redis.core.RedisTemplate;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service(version = "1.0.0")
public class UserServiceImpl extends AbstractBaseService<UserMapper, UserEntity> implements UserService {

    @Resource
    private RedisTemplate<String, String> rdisTemplate;

    private static List<UserEntity> userlist = new ArrayList<UserEntity>();

    @Override
    public UserEntity login(LoginReqVO loginReq) {
        String code = (String) rdisTemplate.opsForValue().get(loginReq.getPhone() + "_verifycode");
        if (null == code) {
            throw new BusinessException("INVALID_CODE", "未获取验证码或验证码已过期！");
        }
        if (!code.equals(loginReq.getVerifycode())) {
            throw new BusinessException("ERROR_CODE", "验证码错误！");
        }
        Example userExample = new Example(UserEntity.class);
        userExample.or().andEqualTo("phone", loginReq.getPhone());
        UserEntity u = this.selectOneByExample(userExample);
        if (u == null) {
            u = new UserEntity();
            u.setNickName("user_" + loginReq.getPhone());
            u.setPhone(loginReq.getPhone());
            this.insert(u);
        }
        return u;
    }

}
