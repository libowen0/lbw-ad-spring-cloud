package com.lbw.ad.vo;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/3/6 Time: 15:31 Description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitRequest {

    private Long planId;
    private String unitName;

    private Integer positionType;
    private Long budget;

    public boolean createValidate(){
        return null!=planId && !StringUtils.isEmpty(unitName)
                && positionType != null && budget != null;
    }
}
