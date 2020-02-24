package com.healthcare.Patient.Managment.System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.healthcare.Patient.Managment.System.configuration",
	"com.healthcare.Patient.Managment.System.controller",
	"com.healthcare.Patient.Managment.System.dao",
	"com.healthcare.Patient.Managment.System.service"})
@EntityScan("com.healthcare.Patient.Managment.System.entity")
public class PatientManagmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientManagmentSystemApplication.class, args);
	}

}
