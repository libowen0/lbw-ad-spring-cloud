package com.lbw.ad.controller;

import com.alibaba.fastjson.JSON;
import com.lbw.ad.exception.AdException;
import com.lbw.ad.service.ICreativeService;
import com.lbw.ad.vo.CreativeRequest;
import com.lbw.ad.vo.CreativeResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/3/14 Time: 21:00 Description:
 */

@Slf4j
@RestController
public class CreativeOPController {

    private final ICreativeService creativeService;

    @Autowired
    public CreativeOPController(ICreativeService creativeService) {
        this.creativeService = creativeService;
    }

    @PostMapping("/create/creative")
    public CreativeResponse createCreative(@RequestBody CreativeRequest request) throws AdException {
        log.info("ad-sponsor: createCreative -> {}", JSON.toJSONString(request));
        return creativeService.createCreative(request);
    }

}
