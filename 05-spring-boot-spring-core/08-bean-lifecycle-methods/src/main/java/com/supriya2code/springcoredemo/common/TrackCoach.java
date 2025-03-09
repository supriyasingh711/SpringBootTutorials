package com.supriya2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }
    //define our init method
    @PostConstruct
    public  void doMyStartupStuff(){
        System.out.println("In domyStartupStuff():"+getClass().getSimpleName());
    }
    //define our destroy method
    @PreDestroy
    public  void doMyCleanupStuff(){
        System.out.println("In domyCleanupStuff():"+getClass().getSimpleName());
    }
}
