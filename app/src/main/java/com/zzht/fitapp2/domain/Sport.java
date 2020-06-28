package com.zzht.fitapp2.domain;
/**
 * Created by zhangruixiang on 2020/6/14.
 */
public class Sport{

    private String id;
    private String name;
    private String mets;

    public Sport(String id, String name, String mets) {
        this.id = id;
        this.name = name;
        this.mets = mets;
    }

    public Sport() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMets() {
        return mets;
    }

    public void setMets(String mets) {
        this.mets = mets;
    }

}
