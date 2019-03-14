package com.lbw.ad.service.impl;

import com.lbw.ad.constant.Constants;
import com.lbw.ad.dao.AdPlanRepository;
import com.lbw.ad.dao.AdUnitRepository;
import com.lbw.ad.dao.CreativeRepository;
import com.lbw.ad.dao.unit_condition.AdUnitDistrictRepository;
import com.lbw.ad.dao.unit_condition.AdUnitItRepository;
import com.lbw.ad.dao.unit_condition.AdUnitKeywordRepository;
import com.lbw.ad.dao.unit_condition.CreativeUnitRepostory;
import com.lbw.ad.entity.AdPlan;
import com.lbw.ad.entity.AdUnit;
import com.lbw.ad.entity.unit_condition.AdUnitDistrict;
import com.lbw.ad.entity.unit_condition.AdUnitIt;
import com.lbw.ad.entity.unit_condition.AdUnitKeyword;
import com.lbw.ad.entity.unit_condition.CreativeUnit;
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/3/6 Time: 15:34 Description:
 */
@Service
public class AdUnitServiceImpl implements IAdUnitService {

    private final AdUnitRepository unitRepository;
    private final AdPlanRepository planRepository;
    private final AdUnitKeywordRepository unitKeywordRepository;
    private final AdUnitDistrictRepository unitDistrictRepository;
    private final AdUnitItRepository unitItRepository;
    private final CreativeRepository creativeRepository;
    private final CreativeUnitRepostory creativeUnitRepostory;

    @Autowired
    public AdUnitServiceImpl(AdUnitRepository unitRepository, AdPlanRepository planRepository, AdUnitDistrictRepository unitDistrictRepository, AdUnitKeywordRepository unitKeywordRepository, AdUnitItRepository unitItRepository, CreativeRepository creativeRepository, CreativeUnitRepostory creativeUnitRepostory) {
        this.unitRepository = unitRepository;
        this.planRepository = planRepository;
        this.unitDistrictRepository = unitDistrictRepository;
        this.unitKeywordRepository = unitKeywordRepository;
        this.unitItRepository = unitItRepository;
        this.creativeRepository = creativeRepository;
        this.creativeUnitRepostory = creativeUnitRepostory;
    }

    @Transactional
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
        return new AdUnitResponse(newAdUnit.getId(), newAdUnit.getUnitName());
    }

    @Transactional
    @Override
    public AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request) throws AdException {

        List<Long> unitIds = request.getUnitKeywords()
                .stream()
                .map(AdUnitKeywordRequest.UnitKeyword::getUnitId)
                .collect(Collectors.toList());
        if (!isRelatedUnitExist(unitIds)) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        List<Long> ids = Collections.emptyList();
        List<AdUnitKeyword> unitKeywords = new ArrayList<>();
        if (!CollectionUtils.isEmpty(request.getUnitKeywords())) {
            request.getUnitKeywords().forEach(i -> unitKeywords.add(
                    new AdUnitKeyword(i.getUnitId(), i.getKeyword())));
            ids = unitKeywordRepository.saveAll(unitKeywords)
                    .stream()
                    .map(AdUnitKeyword::getId)
                    .collect(Collectors.toList());
        }
        return new AdUnitKeywordResponse(ids);
    }

    @Transactional
    @Override
    public AdUnitItResponse createUnitIt(AdUnitItRequest request) throws AdException {
        List<Long> unitIds = request.getUnitIts()
                .stream()
                .map(AdUnitItRequest.UnitIt::getUnitId)
                .collect(Collectors.toList());
        if (!isRelatedUnitExist(unitIds)) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        List<AdUnitIt> unitIts = new ArrayList<>();
        request.getUnitIts().forEach(i -> unitIts.add(new AdUnitIt(i.getUnitId(), i.getItTag())));
        List<Long> ids = unitItRepository.saveAll(unitIts)
                .stream()
                .map(AdUnitIt::getId)
                .collect(Collectors.toList());
        return new AdUnitItResponse(ids);
    }

    @Transactional
    @Override
    public AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request) throws AdException {
        List<Long> unitIds = request.getUnitDistricts()
                .stream()
                .map(AdUnitDistrictRequest.UnitDistrict::getUnitId)
                .collect(Collectors.toList());
        List<AdUnitDistrict> districts = new ArrayList<>();
        if (!isRelatedUnitExist(unitIds)) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        request.getUnitDistricts()
                .forEach(i -> districts.add(new AdUnitDistrict(i.getUnitId(), i.getProvince(), i.getCity())));
        List<Long> ids = unitDistrictRepository.saveAll(districts)
                .stream()
                .map(AdUnitDistrict::getId)
                .collect(Collectors.toList());
        return new AdUnitDistrictResponse(ids);
    }

    @Transactional
    @Override
    public CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request) throws AdException {
        List<Long> creativeIds = request.getUnitItems()
                .stream()
                .map(CreativeUnitRequest.CreativeUnitItem::getCreativeId)
                .collect(Collectors.toList());

        List<Long> unitIds = request.getUnitItems()
                .stream()
                .map(CreativeUnitRequest.CreativeUnitItem::getUnitId)
                .collect(Collectors.toList());
        if (!isRelatedCreativeExist(creativeIds) || !isRelatedUnitExist(unitIds)) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }
        List<CreativeUnit> creativeUnits = new ArrayList<>();
        request.getUnitItems()
                .forEach(i -> creativeUnits.add(new CreativeUnit(i.getCreativeId(), i.getUnitId())));

        List<Long> ids = creativeUnitRepostory.saveAll(creativeUnits)
                .stream()
                .map(CreativeUnit::getId)
                .collect(Collectors.toList());
        return new CreativeUnitResponse(ids);
    }

    /**
     * 相关推广单元是否存在
     */
    private boolean isRelatedUnitExist(List<Long> unitIds) {
        if (CollectionUtils.isEmpty(unitIds)) {
            return false;
        }
        return unitRepository.findAllById(unitIds).size() == new HashSet<>(unitIds).size();
    }

    /**
     * 判断创意是否存在
     */
    private boolean isRelatedCreativeExist(List<Long> creativeIds) {
        if (CollectionUtils.isEmpty(creativeIds)) {
            return false;
        }
        return creativeRepository.findAllById(creativeIds).size() == new HashSet<>(creativeIds).size();
    }
}
