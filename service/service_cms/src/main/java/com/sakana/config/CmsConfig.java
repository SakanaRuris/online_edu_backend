package com.sakana.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author YU Chenxi
 * @since 2023/10/10 22:25
 */
@Configuration
@MapperScan("com.sakana.educms.mapper")
@ComponentScan(basePackages = {"com.sakana"})
public class CmsConfig {

//    /**
//     * 逻辑删除插件
//     */
//    @Bean
//    public ISqlInjector sqlInjector(){
//        return new LogicSqlInjector();
//    }
//
//
//    /**
//     * 分页插件
//     */
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        return new PaginationInterceptor();
//    }
}
