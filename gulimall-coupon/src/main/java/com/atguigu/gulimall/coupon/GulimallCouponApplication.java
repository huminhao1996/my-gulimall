package com.atguigu.gulimall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 如何使用nacos作为配置中心
 * 1.引入依赖
 * <dependency>
 *             <groupId>com.alibaba.cloud</groupId>
 *             <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
 *         </dependency>
 * 2. 创建一个bootstrap.properties
 *          spring.application.name= gulimall-coupon
 *          spring.cloud.nacos.config.server-addr= 127.0.0.1:8848
 * 3. nacos的配置管理中新添加一个 数据集(Data Id) gulimall-coupon.properties 默认规则: 应用名.properties
 * 4. 给 应用名.properties 添加配置
 * 5. 动态获取配置
 *      @RefreshScope  动态获取并刷新配置
 *      @value(${"配置项的名称"}) 获取到配置
 *      如果配置中心和当前应用的配置文件都配置了相同的项,优先使用配置中心的值
 *
 *  细节:
 *  1. 命名空间,配置隔离
 *      默认: public 默认新增的所有配置都在public空间
 *      1. 开发,测试,生产 利用命名空间做环境隔离
 *      spring.cloud.nacos.config.namespace= 命名空间ID
 *      2. 每一个微服务之间互相配置隔离,每一个微服务创建自己的命名空间,只加载自己命名空间中的所有配置
 *
 *  2. 配置集: 所有配置的集合
 *  3. 配置集ID: Data ID , 类似文件名
 *  4. 配置分组: 默认所有的配置集都属于 DEFAULT_GROUP;
 *      例如: 双11节日的配置组,618节日的配置组...
 *
 * 项目中的使用: 每个微服务创建自己的命名空间,使用配置分组区分环境,dev test prod
 *
 * 微服务的任何配置信息,配置文件都可以放到配置中心
 * 只需要在bootstrap.properties中加载配置中心的哪些配置文件即可
 * @value @configurationProperties ....都能使用
 */
@EnableDiscoveryClient //服务注册到nacos
@SpringBootApplication
public class GulimallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallCouponApplication.class, args);
    }

}
