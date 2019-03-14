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
import com.lbw.ad.vo.CreativeUnitRequest;
import com.lbw.ad.vo.CreativeUnitResponse;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/3/6 Time: 15:31 Description:
 */
public interface IAdUnitService {

    /**
     * 创建推广单元
     * @param request
     * @return
     * @throws AdException
     */
    AdUnitResponse createUnit(AdUnitRequest request) throws AdException;

    /**
     * 创建关键字限制
     * @param request
     * @return
     * @throws AdException
     */
    AdUnitKeywordResponse createUnitKeyword(AdUnitKeywordRequest request) throws AdException;

    /**
     * 创建兴趣限制
     * @param request
     * @return
     * @throws AdException
     */
    AdUnitItResponse createUnitIt(AdUnitItRequest request) throws AdException;

    /**
     * 创建区域限制
     * @param request
     * @return
     * @throws AdException
     */
    AdUnitDistrictResponse createUnitDistrict(AdUnitDistrictRequest request) throws AdException;

    CreativeUnitResponse createCreativeUnit(CreativeUnitRequest request) throws AdException;
}
