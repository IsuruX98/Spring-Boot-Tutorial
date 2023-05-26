package com.example.demowebapp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoWebAppApplication.class, args);
    }

    //adding the model mapper to map between classes
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
