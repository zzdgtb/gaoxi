package com.gaoxi.dubbo.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;
import com.gaoxi.base.http.LoginReq;
import com.gaoxi.entity.user.UserEntity;
import com.gaoxi.service.user.UserService;

@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {
	
	private static List<UserEntity> userlist = new ArrayList<UserEntity>();
	
	static{
		userlist.add(new UserEntity("张三","123"));
		userlist.add(new UserEntity("李四","456"));
	}
    @Override
    public UserEntity login(LoginReq loginReq) {
    	if(null==loginReq||null==loginReq.getUsername()||null==loginReq.getPwd()){
    		return null;
    	}
        for(UserEntity u :userlist){
        	if(u.getUsername().equals(loginReq.getUsername())&&u.getPwd().equals(loginReq.getPwd())){
        		return u;
        	}
        }
        return null;
    }
}
