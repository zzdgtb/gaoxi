package com.gaoxi.service.user;

import com.gaoxi.base.http.LoginReq;
import com.gaoxi.entity.user.UserEntity;

public interface UserService {

    public UserEntity login(LoginReq loginReq);
}