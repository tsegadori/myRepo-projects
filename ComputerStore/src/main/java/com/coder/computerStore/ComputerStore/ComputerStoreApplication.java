package com.coder.computerStore.ComputerStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.coder.computerStore.ComputerStore")
public class ComputerStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComputerStoreApplication.class, args);
	}

}
