/*
package com.ttn.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestaurantConfig{

    HotDrink hotDrink;
    @Bean
    Restaurant Restaurant() {
        Restaurant restaurant= new Restaurant();
        restaurant.setHotDrink(hotDrink);
        return restaurant;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Restaurant.class);
        RestaurantConfig restaurantConfig = applicationContext.getBean("rest",RestaurantConfig.class);
        System.out.println(restaurantConfig);
    }



}

*/
