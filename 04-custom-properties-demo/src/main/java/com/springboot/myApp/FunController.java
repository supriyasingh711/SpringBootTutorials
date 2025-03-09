package com.springboot.myApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunController {
    //inject properties for coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    //expose new endooint for "team info"
    @GetMapping("/teamInfo")
    public String getTeamInfo(){
        return "Coach:"+coachName;
    }
    @GetMapping("/")
    public String helloMyApp(){
        return "Hello my app";
    }
    @GetMapping("/w")
    public String hello2(){
        return "Hello2";
    }
}
