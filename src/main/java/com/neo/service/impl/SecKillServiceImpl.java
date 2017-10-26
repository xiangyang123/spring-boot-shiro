package com.neo.service.impl;

import com.neo.dao.SecKillDao;
import com.neo.dao.SecKillOrderDao;
import com.neo.entity.SecKill;
import com.neo.entity.SecKillOrder;
import com.neo.service.RedisService;
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
    @Autowired
    private SecKillOrderDao secKillOrderDao;
    @Autowired
    private RedisService redisService;

    @Override
    public SecKill findById(int goodsId) {
        return secKillDao.findOne(goodsId);
    }

    @Override
    public int resumeSecKill(SecKill secKill) {
        return secKillDao.update(secKill.getId());
    }

    /**
     * 秒杀有可能成功，有可能失败
     * @param customer
     * @param goodsId
     * @return
     */
    @Override
    public String kill(String customer, int goodsId) {
        try {
            Thread.sleep(10);
            SecKill secKill = redisService.getSecKill(goodsId);
            if(secKill == null){
                secKill = secKillDao.findOne(goodsId);
                if(secKill == null){
                    return "无此商品";
                }else{
                    redisService.putSecKill(secKill);
                }
            }
            System.out.println("剩余数量： "+secKill.getRemainNum());
            if(secKill.getRemainNum() > 0){
                //如果secKill剩余数量大于0的话，则减1。
                Thread.sleep(1000);
                int resumeSecKill = secKillDao.update(secKill.getId());
                if(resumeSecKill != 0){
                    SecKillOrder secKillOrder = new SecKillOrder(customer,goodsId,1);
                    secKillOrderDao.save(secKillOrder);
                    return "抢购成功";
                }else {
                    return "抢购失败";
                }
            }else {
                return "暂时缺货";
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "抢购失败";
        }
    }
}
