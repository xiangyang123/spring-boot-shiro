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
    public String simulationCocurrentTakeOrder() {
        //httpClient工厂
        final SimpleClientHttpRequestFactory httpRequestFactory = new SimpleClientHttpRequestFactory();
        //开50个线程模拟并发秒杀下单
        for (int i = 0; i < 50; i++) {
            //购买人姓名
            final String consumerName = "consumer" + i;
            new Thread(new Runnable() {
                @Override
                public void run() {

                    HttpRequest.sendPost(takeOrderUrl,"customer="+consumerName+"&goodsId=123456");
                    System.out.println(consumerName);
                }
            }).start();
        }
        return "simulationCocurrentTakeOrder";
    }
}
