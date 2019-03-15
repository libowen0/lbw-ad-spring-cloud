package com.lbw.ad.controller;

import com.alibaba.fastjson.JSON;
import com.lbw.ad.annotation.IgnoreResponseAdvice;
import com.lbw.ad.client.SponsorClient;
import com.lbw.ad.client.vo.AdPlan;
import com.lbw.ad.client.vo.AdPlanGetRequest;
import com.lbw.ad.vo.CommonResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/3/15 Time: 9:58
 * Description: 通过Rebbon来实现微服务调用
 */

@Slf4j
@RestController
public class SearchController {

    private final RestTemplate restTemplate;
    private final SponsorClient sponsorClient;

    @Autowired
    public SearchController(RestTemplate restTemplate, SponsorClient sponsorClient) {
        this.restTemplate = restTemplate;
        this.sponsorClient = sponsorClient;
    }

    @IgnoreResponseAdvice
    @PostMapping("/getAdPlans")
    public CommonResponse<List<AdPlan>> getAdPlans(@RequestBody AdPlanGetRequest request){
        log.info("ad-search: getAdPlans -> {}",JSON.toJSONString(request));
        return sponsorClient.getAdPlans(request);
    }

    @SuppressWarnings("all")
    @IgnoreResponseAdvice
    @PostMapping("/getAdPlansByRibbon")
    public CommonResponse<List<AdPlan>> getAdPlansByRebbon(@RequestBody AdPlanGetRequest request){
        log.info("ad-search: getAdPlansByRebbon -> {}", JSON.toJSONString(request));
        return restTemplate.postForEntity(
                "http://eureka-client-ad-sponsor/ad-sponsor/get/adPlan",
                request,
                CommonResponse.class).getBody();
    }
}
