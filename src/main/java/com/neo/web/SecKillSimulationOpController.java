package com.neo.web;

import com.neo.util.HttpRequest;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zouxiang on 2017/9/22.
 */
@Controller
public class SecKillSimulationOpController {

    final String takeOrderUrl = "http://127.0.0.1:8080/secKill";

    /**
     * 模拟并发下单
     */
    @RequestMapping("/simulationCocurrentTakeOrder")
    @ResponseBody
    public String simulationCocurrentTakeOrder() throws InterruptedException {

        long beforTime = System.currentTimeMillis();
        //httpClient工厂
        final SimpleClientHttpRequestFactory httpRequestFactory = new SimpleClientHttpRequestFactory();
        //开50个线程模拟并发秒杀下单
        for (int i = 0; i < 1000000; i++) {
            Thread.sleep(1);
            //购买人姓名
            final String consumerName = "consumer" + i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(consumerName + HttpRequest.sendPost(takeOrderUrl,"customer="+consumerName+"&goodsId=123456"));
                }
            }).start();
        }
        System.out.println("时间: "+(System.currentTimeMillis() - beforTime));
        return "simulationCocurrentTakeOrder";
    }
}
