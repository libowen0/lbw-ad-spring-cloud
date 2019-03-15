package com.lbw.ad.client;

import com.lbw.ad.client.vo.AdPlan;
import com.lbw.ad.client.vo.AdPlanGetRequest;
import com.lbw.ad.vo.CommonResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/3/15 Time: 10:06
 * Description: 使用fiegn来调用微服务，实现服务降级
 */

// eureka-client-ad-sponsor服务不可用会自动调用SponsorClientHystrix中的getAdPlans方法
@FeignClient(value = "eureka-client-ad-sponsor",fallback = SponsorClientHystrix.class)
public interface SponsorClient {

    @PostMapping (value = "/ad-sponsor/get/adPlan")
    CommonResponse<List<AdPlan>> getAdPlans(@RequestBody AdPlanGetRequest request);
}
