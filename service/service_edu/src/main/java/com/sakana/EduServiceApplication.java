package com.sakana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author YU Chenxi
 * @since 2023/10/10 22:23
 */
@EnableFeignClients
@SpringBootApplication
public class EduServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduServiceApplication.class,args);
    }
}
