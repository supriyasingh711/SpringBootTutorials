package com.firstProject.springboot.demo.myFirstApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.firstProject")
public class MyFirstAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstAppApplication.class, args);
	}

}
