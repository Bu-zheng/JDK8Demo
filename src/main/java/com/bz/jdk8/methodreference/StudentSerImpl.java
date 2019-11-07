package com.bz.jdk8.methodreference;

public class StudentSerImpl {


    public int compareStudentByScore(Student student1, Student student2){
        return student1.getSocre() - student2.getSocre();
    }

    public  int compareStudentByName(Student student1, Student student2){

        return student1.getName().compareTo(student2.getName());
    }
}
