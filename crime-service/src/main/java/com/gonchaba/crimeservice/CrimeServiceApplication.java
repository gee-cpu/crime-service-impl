package com.gonchaba.crimeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CrimeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrimeServiceApplication.class, args);
    }

}
