package com.lbw.ad.controller;

import com.alibaba.fastjson.JSON;
import com.lbw.ad.entity.AdPlan;
import com.lbw.ad.exception.AdException;
import com.lbw.ad.service.IAdPlanService;
import com.lbw.ad.vo.AdPlanGetRequest;
import com.lbw.ad.vo.AdPlanRequest;
import com.lbw.ad.vo.AdPlanResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/3/14 Time: 20:40 Description:
 */

@Slf4j
@RestController
public class AdPlanOPController {

    private final IAdPlanService planService;

    @Autowired
    public AdPlanOPController(IAdPlanService planService) {
        this.planService = planService;
    }

    @PostMapping("/create/adplan")
    public AdPlanResponse createAdPlan(@RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: createAdPlan -> {}", JSON.toJSONString(request));
        return planService.createAdPlan(request);
    }

    @PostMapping("/get/adplan")
    public List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException{
        log.info("ad-sponsor: getAdPlanByIds -> {}", JSON.toJSONString(request));
        return planService.getAdPlanByIds(request);
    }

    @PutMapping("/update/adplan")
    public AdPlanResponse updateAdPlan(@RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: updateAdPlan -> {}", JSON.toJSONString(request));
        return planService.updateAdPlan(request);
    }

    @DeleteMapping("/delete/adplan")
    public void deleteAdPlan(@RequestBody AdPlanRequest request) throws AdException {
        log.info("ad-sponsor: deleteAdPlan -> {}", JSON.toJSONString(request));
        planService.deleteAdPlan(request);
    }
}
