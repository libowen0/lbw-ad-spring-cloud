package com.lbw.ad.controller;

import com.alibaba.fastjson.JSON;
import com.lbw.ad.exception.AdException;
import com.lbw.ad.service.IUserService;
import com.lbw.ad.vo.CreateUserRequest;
import com.lbw.ad.vo.CreateUserResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/3/14 Time: 20:37 Description:
 */
@Slf4j
@RestController
public class UserOPController {

    private final IUserService userService;

    @Autowired
    public UserOPController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create/user")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request) throws AdException {
        log.info("ad-sponsor: creativeUser -> {}", JSON.toJSONString(request));
        return userService.createUser(request);
    }
}
