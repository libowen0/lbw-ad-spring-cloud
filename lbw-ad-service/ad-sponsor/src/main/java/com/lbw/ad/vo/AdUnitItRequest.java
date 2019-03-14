package com.lbw.ad.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/3/6 Time: 15:51 Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitItRequest {

    private List<UnitIt> unitIts;

    public static class UnitIt{
        private Long unitId;
        private String itTag;
    }
}
