package com.supriya2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements  Coach{

    @Override
    public String getDailyWorkout() {
        return "Spend 30 mins in batting practics";
    }
}
