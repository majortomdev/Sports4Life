package com.majortomdev.sports4life;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Sports4lifeApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sports4lifeApplication.class, args);
	}

}
