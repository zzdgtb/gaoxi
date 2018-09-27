package com.gaoxi.Test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static javafx.scene.input.KeyCode.G;

/**
 * Created by admin on 2018/9/25.
 */
@RestController
public class TestController {
    @GetMapping("/hello")
    public String index(){
        return "hello world!!!";
    }
}
