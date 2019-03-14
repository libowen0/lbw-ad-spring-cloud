package com.lbw.ad.vo;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/2/25 Time: 18:00 Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdPlanRequest {

    private Long id;
    private Long userId;
    private String planName;
    private String startDate;
    private String endDate;

    public Boolean createVaildate(){
        return userId!=null
                && StringUtils.isEmpty(planName)
                && StringUtils.isEmpty(startDate)
                && StringUtils.isEmpty(endDate);
    }

    public boolean updateValidate(){
        return id != null && userId != null;
    }

    public boolean deleteValidate(){
        return id != null && userId != null;
    }
}
