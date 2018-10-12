package com.gaoxi.service.user;

import com.gaoxi.entity.user.UserEntity;
import com.gaoxi.model.user.vo.request.LoginReqVO;
import com.gaoxi.service.base.BaseService;

public interface UserService extends BaseService<UserEntity>{

    public UserEntity login(LoginReqVO loginReq);
}