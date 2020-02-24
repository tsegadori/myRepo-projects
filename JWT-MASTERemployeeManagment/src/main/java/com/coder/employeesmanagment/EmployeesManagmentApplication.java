package com.coder.employeesmanagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.coder.employeesmanagment.JWTsecurity.*","com.coder.employeesmanagment.controller", "com.coder.employeesmanagment.dao", "com.coder.employeesmanagment.Service"})
@EntityScan({"com.coder.employeesmanagment.entity", "com.coder.employeesmanagment.JWTsecurity.model"})
public class EmployeesManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesManagmentApplication.class, args);
	
	}

}
