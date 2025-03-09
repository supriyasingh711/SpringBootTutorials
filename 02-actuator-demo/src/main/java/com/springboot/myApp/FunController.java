package com.springboot.myApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunController {
    @GetMapping("/")
    public String helloMyApp(){
        return "Hello my app";
    }
    @GetMapping("/w")
    public String hello2(){
        return "Hello2";
    }
}
