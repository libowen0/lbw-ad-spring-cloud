package com.lbw.ad.dao;

import com.lbw.ad.entity.AdPlan;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/2/25 Time: 17:06 Description:
 */
public interface AdPlanRepository extends JpaRepository<AdPlan,Long> {

    AdPlan findByIdAndUserId(Long id,Long userId);

    List<AdPlan> findAllByIdInAAndUserId(List<Long> ids,Long userId);

    AdPlan findByUserIdAndPlanName(Long userId,String planName);

    List<AdPlan> findAllByPlanStatus(Integer planStatus);
}
