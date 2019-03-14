package com.lbw.ad.service.impl;

import com.lbw.ad.constant.Constants;
import com.lbw.ad.dao.AdPlanRepository;
import com.lbw.ad.dao.AdUnitRepository;
import com.lbw.ad.entity.AdPlan;
import com.lbw.ad.entity.AdUnit;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/3/6 Time: 15:34 Description:
 */
@Service
public class AdUnitServiceImpl implements IAdUnitService {

    private final AdUnitRepository unitRepository;
    private final AdPlanRepository planRepository;

    @Autowired
    public AdUnitServiceImpl(AdUnitRepository unitRepository, AdPlanRepository planRepository) {
        this.unitRepository = unitRepository;
        this.planRepository = planRepository;
    }

    @Override
    public AdUnitResponse createUnit(AdUnitRequest request) throws AdException {

        if (!request.createValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        Optional<AdPlan> adPlan = planRepository.findById(request.getPlanId());
        if (!adPlan.isPresent()) {
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }

        AdUnit oldUnit = unitRepository.findByPlanIdAndUnitName(request.getPlanId(), request.getUnitName());
        if (oldUnit != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME_UNIT_ERROR);
        }

        AdUnit newAdUnit = unitRepository.save(new AdUnit(request.getPlanId(), request.getUnitName()
                , request.getPositionType(), request.getBudget()));
        return new AdUnitResponse(newAdUnit.getId(),newAdUnit.getUnitName());
    }

    @Override
    public AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request) throws AdException {

        
        return null;
    }

    @Override
    public AdUnitItResponse createUnitIt(AdUnitItRequest request) throws AdException {
        return null;
    }

    @Override
    public AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request) throws AdException {
        return null;
    }
}
