package com.neo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by zouxiang on 2017/9/22.
 * 秒杀的商品
 */
@Entity
public class SecKill implements Serializable{
    @Id
    @GeneratedValue
    private int id; // 编号

    private int remainNum;//剩余商品

    private String goodsName;//商品名字

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRemainNum() {
        return remainNum;
    }

    public void setRemainNum(int remainNum) {
        this.remainNum = remainNum;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
