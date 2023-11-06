package com.sakana.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author YU Chenxi
 * @since 2023/10/18 16:22
 */
@Configuration
@ComponentScan(basePackages = {"com.sakana"})
public class OssServiceConfig {
}
