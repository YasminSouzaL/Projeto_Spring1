package com.srayasmin.projetomc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.srayasmin", "com.srayasmin.controllers"})
public class ProjetomcApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjetomcApplication.class, args);
    }
}
