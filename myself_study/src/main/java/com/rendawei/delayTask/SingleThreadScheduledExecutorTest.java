package com.rendawei.delayTask;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduledExecutorTest {
  public static void main(String[] args) {
    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    service.scheduleAtFixedRate(new Runnable() {
      @Override
      public void run() {
        System.out.println(1);
      }
    }, 0,1, TimeUnit.NANOSECONDS);
  }
}
