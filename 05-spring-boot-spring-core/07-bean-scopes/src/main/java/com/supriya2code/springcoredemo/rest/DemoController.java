package com.supriya2code.springcoredemo.rest;


import com.supriya2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private  Coach anotherCoach;


    @Autowired
    public DemoController(@Qualifier("trackCoach") Coach theCoach,
                            @Qualifier("trackCoach") Coach theAnotherCoach
    ) {
        System.out.println("In Constructor: "+getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach=theAnotherCoach;;
    }
    //In qualifier the name will be same name as class but the first charater will be lowercase




    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();


}
    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCoach==anotheCoach, "+(myCoach==anotherCoach);
    }
}
