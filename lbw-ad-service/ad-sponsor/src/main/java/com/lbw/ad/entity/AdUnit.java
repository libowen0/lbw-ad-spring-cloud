package com.lbw.ad.entity;

import com.lbw.ad.constant.CommonStatus;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/2/25 Time: 13:23 Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ad_unit")
public class AdUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "plan_id",nullable = false)
    private Long planId;

    @Column(name = "unit_name",nullable = false)
    private String unitName;

    @Column(name="unit_status",nullable = false)
    private Integer unitStatus;

    /**
     * 广告位类型（开屏，贴片，中贴..）
     */
    @Column(name = "position_type",nullable = false)
    private Integer positionType;

    /**
     * 预算
     */
    @Column(name = "budget",nullable = false)
    private Long budget;

    @Column(name="create_time",nullable = false)
    private Date createTime;

    @Column(name = "update_time",nullable = false)
    private Date updateTime;

    public AdUnit(Long planId, String unitName, Integer positionType, Long budget) {
        this.planId = planId;
        this.unitName = unitName;
        this.unitStatus = CommonStatus.VALID.getStatus();
        this.positionType = positionType;
        this.budget = budget;
        this.createTime = new Date();
        this.updateTime = this.createTime;
    }
}