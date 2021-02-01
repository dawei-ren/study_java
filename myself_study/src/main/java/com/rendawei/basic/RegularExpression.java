package com.rendawei.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

  public static void main(String[] args) {
    String DATE_STRING = "2017-04-25";
    String P_COMM = "(\\d{4})-((\\d{2})-(\\d{2}))";

    Pattern pattern = Pattern.compile(P_COMM);
    Matcher matcher = pattern.matcher(DATE_STRING);
    matcher.find();//必须要有这句
    System.out.printf("\nmatcher.group(0) value:%s", matcher.group(0));
    System.out.printf("\nmatcher.group(1) value:%s", matcher.group(1));
    System.out.printf("\nmatcher.group(2) value:%s", matcher.group(2));
    System.out.printf("\nmatcher.group(3) value:%s", matcher.group(3));
    System.out.printf("\nmatcher.group(4) value:%s", matcher.group(4));


    System.out.println("----------------------匹配日期----------------");

  }
}
