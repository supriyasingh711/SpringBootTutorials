package com.firstProject.springboot.demo.myFirstApp.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    //expose "/' thatreturn "hello world:
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }
}
