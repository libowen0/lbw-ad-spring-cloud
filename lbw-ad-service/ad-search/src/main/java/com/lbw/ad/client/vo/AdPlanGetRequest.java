package com.lbw.ad.client.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/3/15 Time: 9:54 Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdPlanGetRequest {

    private Long userId;
    private List<Long> ids;
}
