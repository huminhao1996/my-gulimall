package com.atguigu.gulimall.member.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Classname CouponFeignService
 * @Description feign 远程调用service
 * @Date 2021/11/7 11:40
 * @Created by hmh
 */
@FeignClient("gulimall-coupon")
public class CouponFeignService {


}
