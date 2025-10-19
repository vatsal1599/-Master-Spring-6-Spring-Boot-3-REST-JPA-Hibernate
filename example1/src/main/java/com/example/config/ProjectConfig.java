package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This annotation marks a class as a source of bean definitions for the application context.
 * It is an alternative to using XML configuration for defining Spring managed objects.
 * It is typically used in conjunction with the @ComponentScan annotation.
 */
@Configuration
public class ProjectConfig {

    /**
     * This annotation marks a single bean, to be registered in the application context.
     * The method that is annotated with this annotation should return an instance of the bean.
     * The name of the bean can be specified using the name attribute of this annotation.
     * If no name is specified, the name of the bean will be the name of the method.
     * The return type of the method should be the type of the bean.
     */
    @Bean
    Vehicle vehicle() {
        var vehicle = new Vehicle();
        vehicle.setName("Audi 8");
        return vehicle;
    }

    @Bean
    String hello() {
        return "Hello";
    }

    @Bean
    Integer number() {
        return 16;
    }
}
