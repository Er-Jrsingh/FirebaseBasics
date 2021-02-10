package com.firebasebasics;

public class DataHolder {
    private final String name, contact, course, img;

    public DataHolder(String name, String contact, String course, String img) {
        this.name = name;
        this.contact = contact;
        this.course = course;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getCourse() {
        return course;
    }

    public String getimg() {
        return img;
    }
}

