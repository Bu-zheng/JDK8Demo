package com.bz.jdk8.methodreference;

public class Student {

    private String name;

    private int socre;

    public Student(String name, int socre) {
        this.name = name;
        this.socre = socre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSocre() {
        return socre;
    }

    public void setSocre(int socre) {
        this.socre = socre;
    }

    public static int compareStudentByScore(Student student1, Student student2){
        return student1.getSocre() - student2.getSocre();
    }

    public static int compareStudentByName(Student student1, Student student2){

        return student1.getName().compareTo(student2.getName());
    }


    public int compareByScore(Student student){
        return this.getSocre() - student.getSocre();
    }

    public int compareByName(Student student){
        return this.getName().compareTo(student.getName());
    }
}
