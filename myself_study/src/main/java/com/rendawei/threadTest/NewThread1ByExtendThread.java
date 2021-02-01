package com.rendawei.threadTest;


/*
* 多线程的创建方式1：继承与Thread类
*   1. 创建一个继承与Thread类的子类
*   2. 重写Thread类的run()方法: 将此线程执行的操作声明在run方法中
*   3. 创建Thread类的子类的对象
*   4. 通过此对象调用start()
*
* 常用方法
*   start  启动当前线程
*   run   通常需要重写此方法，将创建的线程要执行的操作声明在此方法中
*   currentThread   返回当前线程
*   getName    获取线程名称
*   setName    设置当前线程名称
*   yield      释放当前cpu的执行权，把执行权交给cpu重新分配
*   join       在线程a中调用线程b的join方法，此时线程a就进入阻塞状态，直到线程b完全执行结束以后，线程a才结束阻塞状态
*   stop       强制结束当前线程
*   sleep      强制阻塞一段时间
*   isAlive    判断当前线程是否存活
*
* 线程优先级
*   MAX_PRIORITY:10
*   MIN_PRIORITY:1
*   NORM_PRIORITY:5
*   getPriority   获取线程的优先级
*   setPriority   设置线程的优先级
* */
public class NewThread1ByExtendThread {
  public static void main(String[] args) {
    MyThread myThread = new MyThread();
    myThread.start();

    // 或者可以如下写
    Thread myThread1 = new Thread(){
      @Override
      public void run() {
        System.out.println("myThread2 running...");
      }
    };
    myThread1.start();

    // run方法可以用lambda函数来代替
    Thread myThread2 = new Thread(() -> System.out.println("myThread1 running..."));
    myThread2.start();
  }
}


class MyThread extends Thread{
  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      if (i % 2 == 0){
        System.out.println(i);
      }
    }
  }
}
