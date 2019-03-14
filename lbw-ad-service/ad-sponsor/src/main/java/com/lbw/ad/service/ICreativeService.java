package com.lbw.ad.service;

import com.lbw.ad.exception.AdException;
import com.lbw.ad.vo.CreativeRequest;
import com.lbw.ad.vo.CreativeResponse;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/3/14 Time: 20:04 Description:
 */
public interface ICreativeService {

    CreativeResponse createCreative(CreativeRequest request) throws AdException;
}
