package com.supriya2code.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//		(
//scanBasePackages={"com.supriya2code.springcoredemo",
//					"com.supriya2code.util"
//})//explicitly list base packeages to scan
@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
