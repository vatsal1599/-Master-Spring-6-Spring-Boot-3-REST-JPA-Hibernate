package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        /*
        Vehicle veh1 = context.getBean("audiVehicle",Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + veh1.getName());

        Vehicle veh2 = context.getBean("hondaVehicle",Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + veh2.getName());
        */

//        Vehicle vehicle = context.getBean(Vehicle.class);
//        System.out.println("Vehicle name from Spring Context is: " + vehicle.getName());
//        vehicle.printHello();

        Vehicle volkswagen = new Vehicle();
        volkswagen.setName("Volkswagen");
        Supplier<Vehicle> volkswagenSupplier = () -> volkswagen;

        Supplier<Vehicle> audiSupplier = () -> {
            Vehicle audi = new Vehicle();
            audi.setName("Audi");
            return audi;
        };

        Random random = new Random();
        int randomNumer = random.nextInt(10);

        if (randomNumer % 2 == 0) {
            context.registerBean("volkswagen", Vehicle.class, volkswagenSupplier);
        } else {
            context.registerBean("audi", Vehicle.class, audiSupplier);
        }

        Vehicle volksVehicle = null;
        Vehicle audiVehicle = null;
        try {
            volksVehicle = context.getBean("volkswagen",Vehicle.class);
        }catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException){
            System.out.println("Error while creating Volkswagen vehicle");
        }
        try {
            audiVehicle = context.getBean("audi",Vehicle.class);
        } catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException){
            System.out.println("Error while creating Audi vehicle");
        }

        if (volksVehicle != null) {
            System.out.println("Programming Vehicle name from Spring Context is: " + volksVehicle.getName());
        } else if (audiVehicle != null) {
            System.out.println("Programming Vehicle name from Spring Context is: " + audiVehicle.getName());
        } else {
            System.out.println("No vehicle bean was found in the Spring context");
        }

        context.close();
    }
}
