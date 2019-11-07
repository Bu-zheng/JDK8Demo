package com.bz.jdk8.jodaTime;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class JodaTime1 {
    public static void main(String[] args) {

        //时间加一
        DateTime toDay = new DateTime();
        DateTime tomorrow = toDay.plusDays(1);

        System.out.println(toDay.toString("yyyy-MM-dd"));
        System.out.println(tomorrow.toString("yyyy-MM-dd"));
        System.out.println("=========================");

        //获取本月的第几天
        DateTime dateTime = toDay.withDayOfMonth(2);
        System.out.println(dateTime.toString("yyyy-MM-dd"));
        System.out.println("=========================");


        //获取当前时间
        LocalDate localDate = new LocalDate();
        System.out.println(localDate);
        System.out.println("=========================");

        //获取当前日期往后三个月，当月的最小日期
        LocalDate localDate1 = localDate.plusMonths(3).dayOfMonth().withMinimumValue();
        System.out.println(localDate1);
        System.out.println("=========================");

        //计算2年前第三个月最后一天的日期
        DateTime dateTime1 = new DateTime();
        DateTime dateTime2 = dateTime1.minusYears(2).monthOfYear().
                setCopy(3).dayOfMonth().withMinimumValue();
        System.out.println(dateTime2);


    }
}
