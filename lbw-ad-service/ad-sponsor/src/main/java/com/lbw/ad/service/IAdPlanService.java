package com.lbw.ad.service;

import com.lbw.ad.entity.AdPlan;
import com.lbw.ad.exception.AdException;
import com.lbw.ad.vo.AdPlanGetRequest;
import com.lbw.ad.vo.AdPlanRequest;
import com.lbw.ad.vo.AdPlanResponse;

import java.util.List;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/2/25 Time: 17:59 Description:
 */
public interface IAdPlanService {

    /**
     * <h2>创建推广计划</h2>
     * @param request
     * @return
     * @throws AdException
     */
    AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException;

    /**
     * <h2>获取推广计划</h2>
     * @param request
     * @return
     * @throws AdException
     */
    List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException;

    /**
     * 更新推广计划
     * @param request
     * @return
     * @throws AdException
     */
    AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException;

    /**
     * 删除推广计划
     * @param request
     * @throws AdException
     */
    void deleteAdPlan(AdPlanRequest request) throws AdException;
}
