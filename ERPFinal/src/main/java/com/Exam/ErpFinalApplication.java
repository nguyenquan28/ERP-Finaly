package com.Exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ErpFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpFinalApplication.class, args);
	}

}
