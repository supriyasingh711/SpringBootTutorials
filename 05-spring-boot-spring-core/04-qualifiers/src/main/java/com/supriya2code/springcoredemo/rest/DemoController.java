package com.supriya2code.springcoredemo.rest;


import com.supriya2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("trackCoach") Coach theCoach) {
        myCoach = theCoach;
    }
    //In qualifier the name will be same name as class but the first charater will be lowercase




    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();


}
}
