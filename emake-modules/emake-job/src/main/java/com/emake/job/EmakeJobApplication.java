package com.emake.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EmakeJobApplication {

    public static void main(String[] args) {

        SpringApplication.run(EmakeJobApplication.class, args);
    }
}
