package com.neo.service.impl;

import com.neo.dao.SecKillOrderDao;
import com.neo.entity.SecKillOrder;
import com.neo.service.SecKillOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zouxiang on 2017/9/14.
 */
@Service
public class SecKillOrderServiceImpl implements SecKillOrderService {

    @Autowired
    private SecKillOrderDao secKillOrderDao;

    @Override
    public void save(SecKillOrder secKillOrder) {
        secKillOrderDao.save(secKillOrder);
    }
}
