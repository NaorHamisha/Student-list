package com.example.studentlist.model;

import java.io.Serializable;

public class Student implements Serializable {

    public String name;
    public String id;
    public String address;
    public String phone;
    public String avatarUrl;
    public Boolean cb;

    public Student(String name, String id, String address, String phone, Boolean cb, String avatarUrl) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.avatarUrl = avatarUrl;
        this.cb = cb;
    }

    public Student(String name, String id, String address, String phone, Boolean cb) {
      this(name, id, address, phone, cb, "");
    }
}
