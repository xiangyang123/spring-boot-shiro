package com.neo.service;

import com.neo.entity.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by zouxiang on 2017/9/14.
 */

public interface UserInfoService {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);

    Page<UserInfo> findAll(Pageable pageable);

    void save(UserInfo userInfo);

    void delete(int delId);

    UserInfo findById(int userId);

    void update(UserInfo userInfo);
}
