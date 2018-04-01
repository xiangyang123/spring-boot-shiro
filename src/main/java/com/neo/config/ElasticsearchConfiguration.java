package com.neo.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

/**
 * @author xiangzou
 */
@Configuration
public class ElasticsearchConfiguration  {

    private Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * elk集群地址
     */
    @Value("${spring.data.elasticsearch.host}")
    private String hostName;
    /**
     * 端口
     */
    @Value("${spring.data.elasticsearch.port}")
    private String port;
    /**
     * 集群名称
     */
    @Value("${spring.data.elasticsearch.cluster-name}")
    private String clusterName;

    /**
     * 连接池
     */
    @Value("${spring.data.elasticsearch.pool}")
    private String poolSize;

    @Bean
    public TransportClient init() {

        logger.info("初始化开始。。。。。");
        TransportClient transportClient = null;

        try {
            // 配置信息
            Settings esSetting = Settings.builder()
                    .put("client.transport.sniff", true)//增加嗅探机制，找到ES集群
                    .put("thread_pool.search.size", Integer.parseInt(poolSize))//增加线程池个数，暂时设为5
                    .build();
            transportClient = new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName(hostName), Integer.valueOf(port)));
        } catch (Exception e) {
            logger.error("elasticsearch TransportClient create error!!!", e);
            transportClient.close();
        }
        return transportClient;
    }


}
