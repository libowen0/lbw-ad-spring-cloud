package com.lbw.ad.dao;

import com.lbw.ad.entity.AdUser;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/2/25 Time: 17:04 Description:
 */
public interface AdUserRepository extends JpaRepository<AdUser,Long> {

    /**
     * <h2>根据用户名查询用户记录</h2>
     * @param username
     * @return
     */
    AdUser findByUsername(String username);
}
