package com.lbw.ad.controller;

import com.alibaba.fastjson.JSON;
import com.lbw.ad.exception.AdException;
import com.lbw.ad.service.IAdUnitService;
import com.lbw.ad.vo.AdUnitDistrictRequest;
import com.lbw.ad.vo.AdUnitDistrictResponse;
import com.lbw.ad.vo.AdUnitItRequest;
import com.lbw.ad.vo.AdUnitItResponse;
import com.lbw.ad.vo.AdUnitKeywordRequest;
import com.lbw.ad.vo.AdUnitKeywordResponse;
import com.lbw.ad.vo.AdUnitRequest;
import com.lbw.ad.vo.AdUnitResponse;
import com.lbw.ad.vo.CreativeUnitRequest;
import com.lbw.ad.vo.CreativeUnitResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/3/14 Time: 20:50 Description:
 */

@Slf4j
@RestController
public class AdUnitOPController {

    private final IAdUnitService unitService;

    @Autowired
    public AdUnitOPController(IAdUnitService unitService) {
        this.unitService = unitService;
    }

    @PostMapping("/create/adunit")
    public AdUnitResponse createUnit(@RequestBody AdUnitRequest request) throws AdException {
        log.info("ad-sponsor: createUnit -> {}", JSON.toJSONString(request));
        return unitService.createUnit(request);
    }

    @PostMapping("/create/adunitkeyword")
    public AdUnitKeywordResponse createUnitKeyword(@RequestBody AdUnitKeywordRequest request) throws AdException {
        log.info("ad-sponsor: createUnitKeyword -> {}", JSON.toJSONString(request));
        return unitService.createUnitKeyword(request);
    }

    @PostMapping("/create/adunitit")
    public AdUnitItResponse createUnitIt(@RequestBody AdUnitItRequest request) throws AdException {
        log.info("ad-sponsor: createUnitIt -> {}", JSON.toJSONString(request));
        return unitService.createUnitIt(request);
    }

    @PostMapping("/create/adunitdistrict")
    public AdUnitDistrictResponse createUnitDistrict(@RequestBody AdUnitDistrictRequest request) throws AdException {
        log.info("ad-sponsor: createUnitDistrict -> {}", JSON.toJSONString(request));
        return unitService.createUnitDistrict(request);
    }

    @PostMapping("/create/creativeunit")
    public CreativeUnitResponse createCreativeUnit(@RequestBody CreativeUnitRequest request) throws AdException {
        log.info("ad-sponsor: createCreativeUnit -> {}", JSON.toJSONString(request));
        return unitService.createCreativeUnit(request);
    }
}
