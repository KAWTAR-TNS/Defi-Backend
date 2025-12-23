package com.example.defi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.defi.entities")
public class DefiBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(DefiBackendApplication.class, args);
    }
}
