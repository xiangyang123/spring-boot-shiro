package com.neo.dao;

import com.neo.entity.UserInfo;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zouxiang on 2017/9/14.
 */
public interface UserInfoDao extends JpaRepository<UserInfo,Integer> {
    /**通过username查找用户信息;*/

    public UserInfo findByUsername(String username);

    @Override
    UserInfo save(UserInfo user);
}
