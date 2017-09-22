package com.neo.service;

import com.neo.entity.SecKill;

/**
 * Created by zouxiang on 2017/9/14.
 */
public interface SecKillService {

    SecKill findById(int goodsId);

    int resumeSecKill(SecKill secKill);
}
