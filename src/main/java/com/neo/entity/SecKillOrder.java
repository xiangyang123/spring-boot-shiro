package com.neo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by zouxiang on 2017/9/22.
 * 成功秒杀信息
 */
@Entity
public class SecKillOrder implements Serializable {
    @Id
    @GeneratedValue
    private int id; // 编号

    private String customerName;//用户姓名

    private int goodsId;//产品编号

    private int num;//购买数量

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
