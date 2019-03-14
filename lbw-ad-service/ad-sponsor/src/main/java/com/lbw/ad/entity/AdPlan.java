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
 * Created with IntelliJ IDEA. User: lbw Date: 2019/2/25 Time: 13:14
 * Description: 推广计划表，一个用户对应多个推广计划
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ad_plan")
public class AdPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    /**
     * 关联用户ID
     */
    @Column(name = "user_id",nullable = false)
    private Long userId;

    /**
     * 推广计划名称
     */
    @Column(name = "plan_name",nullable = false)
    private String planName;

    /**
     * 有效状态,无效状态
     * 默认有效状态
     */
    @Column(name = "plan_status",nullable = false)
    private Integer planStatus;

    /**
     * 推广计划开始日期
     */
    @Column(name="start_date",nullable = false)
    private Date startDate;

    /**
     * 推广计划结束日期
     */
    @Column(name="end_date",nullable = false)
    private Date endDate;

    @Column(name="create_time",nullable = false)
    private Date createTime;

    @Column(name = "update_time",nullable = false)
    private Date updateTime;

    public AdPlan(Long userId, String planName, Date startDate, Date endDate) {
        this.userId = userId;
        this.planName = planName;
        this.planStatus = CommonStatus.VALID.getStatus();
        this.startDate = startDate;
        this.endDate = endDate;
        this.createTime = new Date();
        this.updateTime = this.createTime;
    }
}
