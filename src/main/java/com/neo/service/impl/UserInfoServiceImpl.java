package com.neo.service.impl;

import com.neo.dao.UserInfoDao;
import com.neo.entity.UserInfo;
import com.neo.service.UserInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zouxiang on 2017/9/14.
 * @author zouxiang
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }

    /**
     * 启用缓存技术
     * @param pageable
     * @return
     */
    @Override
    public Page<UserInfo> findAll(Pageable pageable) {
        return userInfoDao.findAll(pageable);
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfoDao.save(userInfo);
    }

    @Override
    public void delete(int delId) {
        userInfoDao.delete(delId);
    }

    @Override
    public UserInfo findById(int userId) {
        return userInfoDao.findOne(userId);
    }

    @Override
    public void update(UserInfo userInfo) {
        userInfoDao.saveAndFlush(userInfo);
    }

}
