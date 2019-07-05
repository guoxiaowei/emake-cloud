package com.emake.ssoclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.emake.ssoclient", "com.emake.common.bean"})
public class EmakeSsoclientApplication {

    public static void main(String[] args) {
        log.debug("EmakeSsoclientApplication startup main");
        SpringApplication application = new SpringApplication(EmakeSsoclientApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }


    @LoadBalanced
    @Bean
    public OAuth2RestTemplate restTemplate(UserInfoRestTemplateFactory factory) {
        return factory.getUserInfoRestTemplate();
    }
}
