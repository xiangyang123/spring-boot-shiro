package com.neo.web;

import com.neo.entity.SecKill;
import com.neo.entity.SecKillOrder;
import com.neo.service.SecKillOrderService;
import com.neo.service.SecKillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zouxiang on 2017/9/22.
 */
@Controller
public class SecKillController {
    @Autowired
    private SecKillService secKillService;
    @Autowired
    private SecKillOrderService secKillOrderService;

    @RequestMapping("/secKill")
    @ResponseBody
    public String secKill(String customer,int goodsId) throws InterruptedException {
        SecKill secKill = secKillService.findById(goodsId);
        System.out.println("剩余数量： "+secKill.getRemainNum());
        if(secKill.getRemainNum() > 0){
            Thread.sleep(1000);
            //如果secKill剩余数量大于0的话，则减1。
            int resumeSecKill = secKillService.resumeSecKill(secKill);
            if(resumeSecKill != 0){
                SecKillOrder secKillOrder = new SecKillOrder();
                secKillOrder.setCustomerName(customer);
                secKillOrder.setGoodsId(goodsId);
                secKillOrder.setNum(1);
                secKillOrderService.save(secKillOrder);
                return "success";
            }else {
                return "faild";
            }
        }else {
            return "faild";
        }
    }
}
