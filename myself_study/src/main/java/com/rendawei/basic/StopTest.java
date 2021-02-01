package com.rendawei.basic;

public class StopTest {


  /*
  *
  *
  * 创建钩子，当程序自然结束或者通过Ctrl+c 来结束前，执行一定的逻辑
  *
  * */

  public static void main(String[] args) {
    Thread shutdownThread = new Thread(() -> System.out.println("1111111"));
    Thread thread1 = new Thread(() -> {
      while (true){
        System.out.println(1);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    Runtime.getRuntime().addShutdownHook(shutdownThread);
    thread1.start();

  }
}
