package com.gameloft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GameloftApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameloftApplication.class, args);
	}

}