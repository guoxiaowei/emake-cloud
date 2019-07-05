package com.emake.mps;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.emake.portal.common.fegin"})
@EnableHystrix                // 开启断路器
@EnableHystrixDashboard
@SpringBootApplication(scanBasePackages = {"com.emake.mps", "com.emake.common.bean","com.emake.portal.common"})
public class EmakeMpsApplication {

    public static void main(String[] args) {
        log.debug("EmakeMpsApplication startup main");
        SpringApplication application = new SpringApplication(EmakeMpsApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
