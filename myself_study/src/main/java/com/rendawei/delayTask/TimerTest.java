package com.rendawei.delayTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

  public static void main(String[] args) {

    // 每隔一段时间执行任务
    Timer timer=new Timer();
    // 如果使用scheduleAtFixedRate,如果任务delay，则连续执行
    timer.schedule(new MyTask(2), 1000, 1000);

  }
}


// 任务类，每隔一段时间执行的任务
class MyTask extends TimerTask {
  int i;
  MyTask(int i){
    this.i = i;
  }
  @Override
  public void run() {
    System.out.println("任务开始");
    if (i == 1){
      return;
    }

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println("我的任务结束了" + formatter.format(new Date()));
  }
}
