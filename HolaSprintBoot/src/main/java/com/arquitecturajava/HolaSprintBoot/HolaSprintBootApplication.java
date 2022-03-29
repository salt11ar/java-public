package com.arquitecturajava.HolaSprintBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.arquitecturajava")
public class HolaSprintBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolaSprintBootApplication.class, args);
	}

}
