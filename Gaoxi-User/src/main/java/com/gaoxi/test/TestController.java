package com.gaoxi.Test;

import com.gaoxi.entity.user.UserEntity;
import com.gaoxi.model.user.vo.request.LoginReqVO;
import com.gaoxi.model.user.vo.response.ResultVO;
import com.gaoxi.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by admin on 2018/9/25.
 */
@RestController
public class TestController {
    @Autowired
    private UserService userService;

    @Resource
    private RedisTemplate<String, String> rdisTemplate;

    @GetMapping("/hello")
    public String index() {
        return "hello world!!!";
    }

    @GetMapping("/logintest")
    public UserEntity loginTest() {
        return userService.login(new LoginReqVO("张三", "123"));
    }
    
    @GetMapping("/testtoken")
    public ResultVO testToken() {
    	 MD5TokenUtil myGUID = new MD5TokenUtil();
        return ResultVO.success(myGUID.valueAfterMD5);
    }
    @GetMapping("/testorderid")
    public ResultVO testOrderid() {
        return ResultVO.success(RandomUtils.getRandomStringWithTime(new Date(),6));
    }
    @GetMapping("/test")
    public ResultVO testRedis() {
        SetOperations<String, String> set = rdisTemplate.opsForSet();
        set.add("set1", "22");
        set.add("set1", "33");
        set.add("set1", "44");
        Set<String> resultSet = rdisTemplate.opsForSet().members("set1");
        System.out.println("resultSet:" + resultSet);

        rdisTemplate.opsForZSet().add("set2", "1", 1);
        rdisTemplate.opsForZSet().add("set2", "2", 3);
        rdisTemplate.opsForZSet().add("set2", "3", 2);
        rdisTemplate.opsForZSet().add("set2", "4", 4);
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");
        rdisTemplate.opsForHash().putAll("map1", map);
        Map resultMap = rdisTemplate.opsForHash().entries("map1");
        List reslutMapList = rdisTemplate.opsForHash().values("map1");
        Set resultMapSet = rdisTemplate.opsForHash().keys("map1");
        String value = (String) rdisTemplate.opsForHash().get("map1", "key1");
        System.out.println("value:" + value);
        System.out.println("resultMapSet:" + resultMapSet);
        System.out.println("resultMap:" + resultMap);
        System.out.println("resulreslutMapListtMap:" + reslutMapList);

        List<String> list1 = new ArrayList<String>();
        list1.add("a1");
        list1.add("a2");
        list1.add("a3");

        List<String> list2 = new ArrayList<String>();
        list2.add("b1");
        list2.add("b2");
        list2.add("b3");
        rdisTemplate.opsForList().leftPushAll("listkey1", list1);
        rdisTemplate.opsForList().rightPushAll("listkey2", list2);
        //List<String> resultList1=(List<String>)rdisTemplate.opsForList().leftPop("listkey1");
        // List<String> resultList2=(List<String>)rdisTemplate.opsForList().rightPop("listkey2");
        // System.out.println("resultList1:"+resultList1);
        // System.out.println("resultList2:"+resultList2);
        return ResultVO.success(null);

    }
}
