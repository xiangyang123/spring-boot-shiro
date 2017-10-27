package com.neo.entity;

import java.io.Serializable;

/**
 * Created by zouxiang on 2017/10/26.
 */
public class Tutorial implements Serializable {

    private Long id;
    private String name;//教程名称

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Tutorial{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
