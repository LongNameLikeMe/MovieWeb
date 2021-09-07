package com.web.movie.entity;

public class UserInfo {

    private int id;
    private String name;
    private String email;
    private String qq;
    private int age;

    public UserInfo() {
    }

    public UserInfo(int id, String name, String email, String qq, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.qq = qq;
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", age=" + age +
                '}';
    }
}
