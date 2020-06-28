package com.zzht.fitapp2.domain;
/**
 * Created by zhangruixiang on 2020/6/14.
 */
public class Food{

    private String id;
    private String name;
    private String calory;

    public Food(String id, String name, String calory) {
        this.id = id;
        this.name = name;
        this.calory = calory;
    }
    public Food(){}

    public String getCalory() {
        return calory;
    }

    public void setCalory(String calory) {
        this.calory = calory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
