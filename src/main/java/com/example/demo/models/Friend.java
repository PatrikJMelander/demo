package com.example.demo.models;

/**
 * Created by Patrik Melander
 * Date: 2021-04-08
 * Time: 14:22
 * Project: demo
 * Copyright: MIT
 */
public class Friend {
    public int id;
    public String name;
    public String address;
    public String phone;

    public Friend(int id, String name, String address, String phone){
        this.id=id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
