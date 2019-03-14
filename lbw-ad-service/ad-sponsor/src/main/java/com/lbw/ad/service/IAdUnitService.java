package com.lbw.ad.service;

import com.lbw.ad.exception.AdException;
import com.lbw.ad.vo.AdUnitDistrictRequest;
import com.lbw.ad.vo.AdUnitDistrictResponse;
import com.lbw.ad.vo.AdUnitItRequest;
import com.lbw.ad.vo.AdUnitItResponse;
import com.lbw.ad.vo.AdUnitKeywordRequest;
import com.lbw.ad.vo.AdUnitKeywordResponse;
import com.lbw.ad.vo.AdUnitRequest;
import com.lbw.ad.vo.AdUnitResponse;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/3/6 Time: 15:31 Description:
 */
public interface IAdUnitService {

    AdUnitResponse createUnit(AdUnitRequest request) throws AdException;

    AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request) throws AdException;

    AdUnitItResponse createUnitIt(AdUnitItRequest request) throws AdException;

    AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request) throws AdException;
}
