package com.neo.web;

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
        //判断是否还有商品未被抢购。如果抢购完，则直接返回已抢购完。

        return secKillService.kill(customer,goodsId);
    }
}
