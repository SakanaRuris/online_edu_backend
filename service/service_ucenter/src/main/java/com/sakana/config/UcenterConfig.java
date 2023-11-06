package com.sakana.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author YU Chenxi
 * @since 2023/10/10 22:25
 */
@EnableDiscoveryClient
@Configuration
@MapperScan("com.sakana.educenter.mapper")
@ComponentScan(basePackages = {"com.sakana"})
public class UcenterConfig {

}
