package com.petrushevsky.itemstestapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ItemsTestAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemsTestAppApplication.class, args);
    }


}
