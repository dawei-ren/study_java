package com.rendawei.myDate;

import java.util.concurrent.TimeUnit;

public class TestTimeUnit {
  public static void main(String[] args) {
    System.out.println("将时间戳转化成微秒粒度");
    long timestamp = 1000L;

    TimeUnit timeUnit = TimeUnit.MILLISECONDS;

//    long res = timeUnit.toMicros(timestamp);
    long res = timeUnit.convert(timestamp, TimeUnit.MICROSECONDS);
    System.out.println(res);
  }
}
