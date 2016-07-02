package com.app.DB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class DatabaseDesignApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDesignApplication.class, args);
	}
}
