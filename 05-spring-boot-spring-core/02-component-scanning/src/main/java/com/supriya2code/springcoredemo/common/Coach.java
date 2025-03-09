package com.supriya2code.springcoredemo.common;

import org.springframework.stereotype.Component;

public interface Coach {
    String getDailyWorkout();

    @Component
    class Cricket implements Coach {
        @Override
        public String getDailyWorkout(){
            return "Practice fast bowling for 15 mins";
        }

    }
}
