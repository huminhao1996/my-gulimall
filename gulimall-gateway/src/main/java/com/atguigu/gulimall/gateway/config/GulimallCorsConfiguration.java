package com.atguigu.gulimall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @Classname CorsConfiguration
 * @Description 跨域配置
 * @Date 2021/11/8 22:42
 * @Created by hmh
 */

@Configuration
public class GulimallCorsConfiguration {

    @Bean
    public CorsWebFilter corsWebFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();

        //1、配置跨域
        corsConfiguration.addAllowedHeader("*"); // 请求头
        corsConfiguration.addAllowedMethod("*"); // 方法
        corsConfiguration.addAllowedOrigin("*"); // 请求源
        corsConfiguration.setAllowCredentials(true); // 携带cookie

        source.registerCorsConfiguration("/**", corsConfiguration); //任意路径都要进行跨域配置
        return new CorsWebFilter(source);
    }
}
