package com.ttn.spring.RestSpringExercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.ttn.spring.RestSpringExercise.repository")
@EntityScan(basePackages = {"com.ttn.spring.RestSpringExercise.entity"})
@SpringBootApplication
public class RestSpringExerciseApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestSpringExerciseApplication.class, args);
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames("i18n/messages");
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }
}
