package com.lbw.ad.service.impl;

import com.lbw.ad.constant.Constants;
import com.lbw.ad.dao.AdUserRepository;
import com.lbw.ad.entity.AdUser;
import com.lbw.ad.exception.AdException;
import com.lbw.ad.service.IUserService;
import com.lbw.ad.utils.CommonUtils;
import com.lbw.ad.vo.CreateUserRequest;
import com.lbw.ad.vo.CreateUserResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/2/25 Time: 17:33 Description:
 */

@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    private final AdUserRepository adUserRepository;

    @Autowired
    public UserServiceImpl(AdUserRepository adUserRepository) {
        this.adUserRepository = adUserRepository;
    }

    @Override
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest request) throws AdException {

        if(!request.validate()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        AdUser oldUser =adUserRepository.findByUsername(request.getUsername());
        if(oldUser!=null){
            throw new AdException(Constants.ErrorMsg.SAME_NAME_ERROR);
        }
        AdUser newUser = adUserRepository.save(new AdUser(request.getUsername(), CommonUtils.md5(request.getUsername())));
        return new CreateUserResponse(newUser.getId(),newUser.getUsername(),newUser.getToken(),newUser.getCreateTime(),newUser.getUpdateTime());
    }
}
