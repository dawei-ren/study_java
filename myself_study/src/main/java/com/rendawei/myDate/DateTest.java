package com.rendawei.myDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTest {
  public static void main(String[] args) throws ParseException {
    Date date = new Date();
    System.out.println(date);

    // 将时间格式化成字符串
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String nowStr = formatter.format(date);
    System.out.println(nowStr);

    // 获取时间戳
    long timestamp = date.getTime();
    System.out.println(timestamp);

    // 使用System.currentMillis() 获取时间戳,就不用再实例化Time
    long timestamp2 = System.currentTimeMillis();

    System.out.println(timestamp2);


    System.out.println("将时间戳转化为时间");
    long now_timestamp = System.currentTimeMillis();
    long test = 1604992021048L;
    System.out.println("当前时间戳：" + now_timestamp);

    System.out.println("当前时间：" + formatter.format(now_timestamp));

    SimpleDateFormat format_8 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    format_8.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
    System.out.println("当前北京时间：" + format_8.format(now_timestamp));
    System.out.println("当前时间：" + formatter.format(test));


    System.out.println("将时间转化为时间戳");

    String s = "2020-08-23-00-00-13";

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    Date date1 = simpleDateFormat.parse(s);
    long ts = date.getTime();
    System.out.println(s);
    System.out.println(date1);
    System.out.println(ts);


  }

}
