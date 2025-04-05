package com.supriya.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    //need a controller method to show initial HTML form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }


    //need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }
    @RequestMapping("/processFormVersionThree")
    public String processFormVersionGThree(@RequestParam("studentName") String theName, Model model){
        //read the request parameter from the HTML form
        //convert the data to all caps
        theName=theName.toUpperCase();

        //create the message
        String result="Hey my friend "+theName;

        //add message to the model
        model.addAttribute("message",result);

        return "helloworld";
    }

}
