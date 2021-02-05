package com.firebasebasics.Models;

public class  Users {
    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getPhone() {
        return phone;
    }

    private  final  String name,course,phone;

    public Users(String name, String course, String phone) {
        this.name = name;
        this.course = course;
        this.phone = phone;
    }
}
