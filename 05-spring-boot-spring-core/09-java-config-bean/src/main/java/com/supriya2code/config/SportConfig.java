package com.supriya2code.config;

import com.supriya2code.springcoredemo.common.Coach;
import com.supriya2code.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
