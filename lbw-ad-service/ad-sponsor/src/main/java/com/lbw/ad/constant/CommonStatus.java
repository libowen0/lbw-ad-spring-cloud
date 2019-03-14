package com.lbw.ad.constant;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/2/25 Time: 12:55 Description:
 */

@Getter
public enum CommonStatus {

    VALID(1, "有效状态"),
    INVALID(0, "无效状态");

    private Integer status;
    private String desc;

    CommonStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
