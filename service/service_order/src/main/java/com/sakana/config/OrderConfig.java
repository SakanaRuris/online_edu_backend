package com.sakana.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author YU Chenxi
 * @since 2023/10/31 20:52
 */
@Configuration
@MapperScan("com.sakana.eduorder.mapper")
@ComponentScan(basePackages = {"com.sakana"})

public class OrderConfig {
}
