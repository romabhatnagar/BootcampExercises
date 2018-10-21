package com.ttn.springBoot.SpringBootExercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootExerciseApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootExerciseApplication.class, args);
	}

//	Question3
	@Bean
	public User user() {
		User user = new User();
		user.setName("roma");
		user.setPassword("123");
		return user;
	}

}
