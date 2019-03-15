package com.lbw.ad.client;

import com.lbw.ad.client.vo.AdPlan;
import com.lbw.ad.client.vo.AdPlanGetRequest;
import com.lbw.ad.vo.CommonResponse;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/3/15 Time: 10:11 Description:
 */
@Component
public class SponsorClientHystrix implements SponsorClient {
    @Override
    public CommonResponse<List<AdPlan>> getAdPlans(AdPlanGetRequest request) {
        return new CommonResponse<>(-1,"eureka-client-ad-sponsor error");
    }
}
