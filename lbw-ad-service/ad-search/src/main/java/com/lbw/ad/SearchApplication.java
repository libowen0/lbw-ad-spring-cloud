package com.lbw.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/3/15 Time: 9:29 Description:
 */

@EnableEurekaClient
// 使用feign来访问其他微服务
@EnableFeignClients
// 使用断路器
@EnableHystrix
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableHystrixDashboard
@SpringBootApplication
public class SearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class,args);
    }

    @Bean
//    开启负载均衡
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
