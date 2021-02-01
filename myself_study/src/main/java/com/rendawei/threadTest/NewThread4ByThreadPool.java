package com.rendawei.threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
*
* 创建线程的方式4： 使用线程池
*
*     好处：2
*         提高响应速度（减少了创建新线程的时间）
*         降低资源消耗（重复利用线程池中线程，不需要每次都创建）
*         便于线程管理
*           corePoolSize： 核心池的大小
*           maximunPoolSize： 最大线程数
*           keepAliveTime：线程没有任务时最多保持多长时间后会终止
* */

class NumberThread implements Runnable{
  @Override
  public void run() {
    for (int i = 0; i <= 100; i++){
      if (i % 2 == 0){
        System.out.println(Thread.currentThread().getName() + ": " + i);
      }
    }
  }
}

class NumberThread1 implements Runnable{
  @Override
  public void run() {
    for (int i = 0; i <= 100; i++){
      if (i % 2 == 1){
        System.out.println(Thread.currentThread().getName() + ": " + i);
      }
    }
  }
}

public class NewThread4ByThreadPool {
  public static void main(String[] args) {
    // 1. 提供指定数量的线程池
    ExecutorService service = Executors.newFixedThreadPool(10);
    // 2. 执行指定的线程的操作，需要提供实现Runnable接口或Callable接口实现类的对象
    service.execute(new NumberThread()); // 适合使用Runnable
    service.execute(new NumberThread1()); // 适合使用Runnable
//    service.submit(); // 适合使用Callable
    // 3. 关闭线程池
    service.shutdown();
  }
}
