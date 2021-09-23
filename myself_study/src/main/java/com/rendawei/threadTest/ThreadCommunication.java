package com.rendawei.threadTest;

public class ThreadCommunication {
  static C c = new C();
  static volatile boolean flag = false;

  public static void main(String[] args) {
    c.setValue(12);
    System.out.println("子线程执行之前value值是：" + c.getValue());
    System.out.println("执行子线程");

    MyTaskThread myTaskThread = new MyTaskThread(c);

    myTaskThread.start();

    // 等待子线程结束
    while (!flag)
    System.out.println("子线程结束之后的value值是：" + c.getValue());
  }


  public static void callback() {
    System.out.println("子线程执行结束");
    flag = true;

  }
}

class C {
  private int value = 0;

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}

class MyTaskThread extends Thread{
  private final C cc;
  public MyTaskThread(C cc) {
    this.cc = cc;
  }

  @Override
  public void run() {

    while (cc.getValue() < 20) {
      System.out.println(cc.getValue());
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      cc.setValue(cc.getValue() + 1);
    }

    ThreadCommunication.callback();
  }
}

