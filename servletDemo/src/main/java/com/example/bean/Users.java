package com.example.bean;

import java.util.List;

public class Users {
    private int id;
    private String uname;
    private int uage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", uage=" + uage +
                '}';
    }

}
