package com.bz.jdk8.Java8Time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

public class Java8TimeTest1 {

    public static void main(String[] args) {
        //当前时间（当前时区的时间）
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        System.out.println(localDate.getYear() + ", " + localDate.getMonthValue() + "" +
                ", " + localDate.getDayOfMonth());
        System.out.println("-----------------------");

        //构造一个日期
        LocalDate localDate2 = LocalDate.of(2018, 3, 3);
        System.out.println(localDate2);
        System.out.println("-----------------------");

        LocalDate localDate3 = LocalDate.of(2010, 3, 25);
        MonthDay monthDay = MonthDay.of(localDate3.getMonth(), localDate3.getDayOfMonth());
        MonthDay monthDay2 = MonthDay.from(LocalDate.of(2018, 3, 25));

        if (monthDay.equals(monthDay2)) {
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }
        System.out.println("-----------------------");

        //只到时分秒
        LocalTime time = LocalTime.now();
        String format = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(format);
        System.out.println(time);

        //加上2小时20分钟
        LocalTime localTime = time.plusHours(2).plusMinutes(20);
        System.out.println(localTime);

    }
}
