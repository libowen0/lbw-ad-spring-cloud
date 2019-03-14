package com.lbw.ad.service.impl;

import com.lbw.ad.constant.Constants;
import com.lbw.ad.dao.AdUserRepository;
import com.lbw.ad.dao.CreativeRepository;
import com.lbw.ad.entity.AdUser;
import com.lbw.ad.entity.Creative;
import com.lbw.ad.exception.AdException;
import com.lbw.ad.service.ICreativeService;
import com.lbw.ad.vo.CreativeRequest;
import com.lbw.ad.vo.CreativeResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/3/14 Time: 20:11 Description:
 */
@Service
public class CreativeServiceImpl implements ICreativeService {

    private final CreativeRepository creativeRepository;

    private final AdUserRepository userRepository;

    @Autowired
    public CreativeServiceImpl(CreativeRepository creativeRepository, AdUserRepository userRepository) {
        this.creativeRepository = creativeRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public CreativeResponse createCreative(CreativeRequest request) throws AdException {

        Optional<AdUser> oldUser = userRepository.findById(request.getUserId());
        if(oldUser.isPresent()){
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        Creative creative = creativeRepository.save(request.convertToEntity());
        return new CreativeResponse(creative.getId(),creative.getName());
    }
}
