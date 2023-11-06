package com.sakana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author YU Chenxi
 * @since 2023/10/18 16:14
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class OssApplication {

    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class,args);
    }
}
