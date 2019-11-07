package com.bz.jdk8.stream2;

import com.bz.jdk8.model.Student;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamTest1 {
    public static void main(String[] args) {

        Student stu1 = new Student("张三", 92);
        Student stu2 = new Student("李四", 100);
        Student stu3 = new Student("王武", 80);
        Student stu4 = new Student("张三", 100);
        Student stu5 = new Student("张三", 100);

        List<Student> studentList = Arrays.asList(stu1, stu2, stu3, stu4, stu5);
//        //计算集合的长度
//        //方法一：
//        Long countByCounting = studentList.stream().collect(counting());
//        //方法二：
//        long countByCout = studentList.stream().count();

        //求成绩总和
        long sum = studentList.stream().collect(Collectors.summingInt(Student::getScore));
        //取最大值
        int max = studentList.stream().collect(Collectors.summarizingInt(Student::getScore)).getMax();
        System.out.println("max==="+max);
        System.out.println(sum);


        //分组求和
        Map<String, Integer> collect2 = studentList.stream().collect(Collectors.groupingBy(Student::getName, Collectors.summingInt(Student::getScore)));
        System.out.println(collect2);

        //取最小值
        System.out.println("============");
        int min = studentList.stream().collect(Collectors.summarizingInt(Student::getScore)).getMin();
        System.out.println("取最小值===>"+min);

        studentList.stream().collect(Collectors.minBy(Comparator.comparing(Student::getScore))).ifPresent(System.out::println);
        studentList.stream().collect(Collectors.maxBy(Comparator.comparing(Student::getScore))).ifPresent(System.out::println);
        Double avg = studentList.stream().collect(averagingInt(Student::getScore));
        System.out.println("平均值==="+avg);

        System.out.println("============");
        //求汇总信息
        IntSummaryStatistics intSummaryStatistics = studentList.stream().collect(Collectors.summarizingInt(Student::getScore));
        System.out.println("求汇总信息====>"+intSummaryStatistics);

        System.out.println("============");
        //拼接
        String str = studentList.stream().map(Objects::toString).collect(Collectors.joining(","));
        String str2 = studentList.stream().map(Student::getName).
                collect(Collectors.joining("", "<begin>", "<end>"));
        System.out.println(str);
        System.out.println(str2);

        //二级分组，先根据分数分组，在根据名字分组
        System.out.println("============");
        Map<Integer, Map<String, List<Student>>> map = studentList.stream().
                collect(groupingBy(Student::getScore, groupingBy(Student::getName)));
        List<Student> studentList1 = map.get(100).get("张三");
        studentList1.forEach(System.out::println);
        System.out.println();


        //分区  ： true 跟false
        System.out.println("============");
        Map<Boolean, List<Student>> map1 = studentList.stream().collect(partitioningBy(student -> student.getScore() > 90));
        System.out.println(map1);
        System.out.println("==" +
                "==========");
        Map<Boolean, Map<Boolean, List<Student>>> map2 = studentList.stream().
                collect(partitioningBy(student -> student.getScore() > 90, partitioningBy(stu -> stu.getScore() == 100)));
        System.out.println(map2);

    }


}
