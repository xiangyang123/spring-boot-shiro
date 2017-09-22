package com.neo.service.impl;

import com.neo.dao.SecKillDao;
import com.neo.entity.SecKill;
import com.neo.service.SecKillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zouxiang on 2017/9/14.
 */
@Service
public class SecKillServiceImpl implements SecKillService {

    @Autowired
    private SecKillDao secKillDao;

    @Override
    public SecKill findById(int goodsId) {
        return secKillDao.findOne(goodsId);
    }

    @Override
    public int resumeSecKill(SecKill secKill) {
//        int remainNum = secKill.getRemainNum();
//        if(remainNum > 0){
//            secKill.setRemainNum(remainNum -1);
//            secKillDao.saveAndFlush(secKill);
//            return true;
//        }
        return secKillDao.update(secKill.getId());
    }
}
