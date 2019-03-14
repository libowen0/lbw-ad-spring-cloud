package com.lbw.ad.service;

import com.lbw.ad.exception.AdException;
import com.lbw.ad.vo.CreateUserRequest;
import com.lbw.ad.vo.CreateUserResponse;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/2/25 Time: 17:25 Description:
 */

public interface IUserService {

    /**
     * <h2>创建用户</h2>
     * @param request
     * @return
     * @throws AdException
     */
    CreateUserResponse createUser(CreateUserRequest request) throws AdException;
}
