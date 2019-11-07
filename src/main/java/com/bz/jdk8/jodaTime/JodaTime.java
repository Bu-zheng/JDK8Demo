package com.bz.jdk8.jodaTime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

public class JodaTime {

    //标准UTC时间 2019-11-04T09:33:33.897z

    //标准UTC时间转成当前时区时间
    public  static Date convertUTC2Date(String utcDate){
        try{
            DateTime dateTime = DateTime.parse(utcDate, DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
            return dateTime.toDate();

        }catch (Exception ex){
            return null;
        }
    }

    //将时间转成标准UTC时间
    public static String convertDate2UTC(Date javaDate){
        DateTime dateTime = new DateTime(javaDate, DateTimeZone.UTC);
        return dateTime.toString();
    }


    public static String convertDate2LocalByDateFormat(Date javaDate, String dateFormat){
        DateTime dateTime = new DateTime(javaDate);
        return dateTime.toString(dateFormat);
    }


    public static void main(String[] args) {

        //标准UTC时间转成当前时区时间  （+8，中国在东8区）
        System.out.println(JodaTime.convertUTC2Date("2019-11-04T09:33:33.897z"));

        //转换成标准UTC时间 （-8，中国在东8区）
        System.out.println(JodaTime.convertDate2UTC(new Date()));

        //将时间格式化
        System.out.println(JodaTime.convertDate2LocalByDateFormat(
                new Date(), "yyyy-MM-dd"
        ));

    }

}
