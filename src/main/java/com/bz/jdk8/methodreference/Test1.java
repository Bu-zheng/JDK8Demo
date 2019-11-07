package com.bz.jdk8.methodreference;

import com.bz.jdk8.Test.MethodReferenceDemo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Test1 {

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 10);
        Student student2= new Student("lisi", 180);
        Student student3 = new Student("wangwu", 90);
        Student student4 = new Student("zhaoliu", 100);

        List<Student> studentList = Arrays.asList(student1, student2, student3, student4);

        //使用lambda表达式进行排序
//        studentList.sort((studentParam1, studentParam2) ->
//                Student.compareStudentByScore(studentParam1, studentParam2));
//        studentList.forEach(student -> System.out.println(student.getSocre()));

        //方法表达式进行排序
//        studentList.sort(Student::compareStudentByScore);
//        studentList.forEach(student -> System.out.println(student.getSocre()));


//        StudentSerImpl studentSer = new StudentSerImpl();

        //使用lambda表达式进行排序
//        studentList.sort((studentParam1, studentParam2) ->
//                studentSer.compareStudentByScore(studentParam1, studentParam2));
//        studentList.forEach(student -> System.out.println(student.getSocre()));

        //方法表达式进行排序
//        studentList.sort(studentSer::compareStudentByScore);
//        studentList.forEach(student -> System.out.println(student.getSocre()));

        //list中的第一个Student对象取调用了compareByScore方法，但是第二Student对象作为compareByScore的参数传入
//        studentList.sort(Student::compareByScore);
//        studentList.forEach(student -> System.out.println(student.getSocre()));

//        List<String> cities = Arrays.asList("qingdao", "fuzhou", "sanming", "quanzhou");
//
//        Collections.sort(cities, (city1, city2) -> city1.compareToIgnoreCase(city2));
//        cities.forEach(it -> System.out.println(it));
//
//        //上面等价于, city1相当于调用了函数compareToIgnoreCase, city2相当作为compareToIgnoreCase的参数
//        Collections.sort(cities, String::compareToIgnoreCase);
//        cities.forEach(System.out::println);


        Test1 test1 = new Test1();
        System.out.println(test1.getString(String::new));

        System.out.println("=============");

        System.out.println(test1.getString2("别想太多", String::new));

    }

    public String getString(Supplier<String> supplier){

        return supplier.get() + "test:";
    }

    public String getString2(String str, Function<String, String> function){
        return function.apply(str);
    }
}
