package com.emake.eureka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@Slf4j
@EnableEurekaServer
@SpringBootApplication
public class EmakeEurekaApplication {

    public static void main(String[] args) {
        log.debug("EmakeEurekaApplication startup main");
        SpringApplication application = new SpringApplication(EmakeEurekaApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
