package com.zzht.fitapp2.domain;

import java.io.Serializable;

public class Person implements Serializable {
    private int id;
    private int image;
    private String name;
    private String phone;
    private String password;

    public Person(int id, int image, String name, String phone, String password) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.phone = phone;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
