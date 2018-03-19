package com.neo.service;

import com.neo.SpringBootShiroApplication;
import com.neo.dao.UserInfoDao;
import com.neo.entity.UserInfo;
import com.neo.util.ElasticsearchUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootShiroApplication.class)
public class UserInfoServiceTest {

    @Autowired
    private UserInfoDao userInfoDao;
    @Test
    public void save() {

        UserInfo userInfo = new UserInfo();
        userInfo.setName("邹翔");
//        userInfo.setUsername("邹翔3");
        userInfoDao.save(userInfo);
        List<UserInfo> userInfoList = userInfoDao.findAll();
    }


    @Test
    public void createIndexTest(){
//        ElasticsearchUtils.createIndex("java_index");
        System.out.println(ElasticsearchUtils.searchListData("address","",0,"","",true,"message","message=北京"));
    }
}