package com.lbw.ad.dao;

import com.lbw.ad.entity.AdUnit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/2/25 Time: 17:09 Description:
 */
public interface AdUnitRepository extends JpaRepository<AdUnit,Long> {

    AdUnit findByPlanIdAndUnitName(Long planId,String unitName);

    List<AdUnit> findAllByUnitStatus(Integer unitStatus);
}
