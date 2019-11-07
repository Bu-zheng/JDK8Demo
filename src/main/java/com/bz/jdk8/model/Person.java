package com.bz.jdk8.model;

public class Person {

    private String userName;

    private Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person(String userName, Integer age) {

        this.userName = userName;
        this.age = age;
    }

    public Person() {
    }
}
