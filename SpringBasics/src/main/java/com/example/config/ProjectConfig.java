package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * This annotation marks a class as a source of bean definitions for the application context.
 * It is an alternative to using XML configuration for defining Spring managed objects.
 * It is typically used in conjunction with the @ComponentScan annotation.
 */
@Configuration
@ComponentScan("com.example.beans")
public class ProjectConfig {

    /**
     * This annotation marks a single bean, to be registered in the application context.
     * The method that is annotated with this annotation should return an instance of the bean.
     * The name of the bean can be specified using the name attribute of this annotation.
     * If no name is specified, the name of the bean will be the name of the method.
     * The return type of the method should be the type of the bean.
     */

   /*
   @Bean(name="audiVehicle")
    Vehicle vehicle1() {
        var vehicle = new Vehicle();
        vehicle.setName("Audi");
        return vehicle;
    }

    @Bean(name="hondaVehicle")
    Vehicle vehicle2() {
        var vehicle = new Vehicle();
        vehicle.setName("Honda");
        return vehicle;
    }

    @Primary
    @Bean(name="ferrariVehicle")
    Vehicle vehicle3() {
        var vehicle = new Vehicle();
        vehicle.setName("Ferrari");
        return vehicle;
    }
*/

}
