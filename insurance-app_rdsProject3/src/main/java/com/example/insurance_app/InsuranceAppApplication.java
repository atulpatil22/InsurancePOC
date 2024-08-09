package com.example.insurance_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.insurance_app")
public class InsuranceAppApplication {

	public static void main(String[] args) {
		System.out.println("Inside Run");
		SpringApplication.run(InsuranceAppApplication.class, args);

	}

}
