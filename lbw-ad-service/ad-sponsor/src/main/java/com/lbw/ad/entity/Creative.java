package com.lbw.ad.entity;

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
 * Created with IntelliJ IDEA. User: lbw Date: 2019/2/25 Time: 13:48
 * Description: 创意表，一个用户可以上传多个创意
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ad_creative")
public class Creative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 创意名称
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 表示物料类型（图片，文本，视频）
     */
    @Column(name = "type", nullable = false)
    private Integer type;

    /**
     * 物料的类型，如图片可以是jpg,png..
     */
    @Column(name = "material_type", nullable = false)
    private Integer materialType;

    /**
     * 物料高度
     */
    @Column(name = "height", nullable = false)
    private Integer height;

    /**
     * 物料宽度
     */
    @Column(name = "width", nullable = false)
    private Integer width;

    /**
     * 物料大小
     */
    @Column(name = "size", nullable = false)
    private Long size;

    /**
     * 持续时间，只有视频不为0
     */
    @Column(name = "duration", nullable = false)
    private Integer duration;

    /**
     * 审核状态
     */
    @Column(name = "audit_status", nullable = false)
    private Integer auditStatus;


    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Column(name = "update_time", nullable = false)
    private Date updateTime;
}
