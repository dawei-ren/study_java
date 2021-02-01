package com.rendawei.threadTest;

/*
*   创建多线程的方式二： 实现Runnable接口
*     1. 创建一个实现了Runnable接口的类
*     2. 实现类去实现Runnable中的抽象方法：run（）
*     3. 创建实现类的对象
*     4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
*     5. 通过Thread类的对象调用start（）
*
*   相比于继承，实现Runnable接口的方式有啥好处
*     开发中优先选择实现Runnable接口的方式
*     1. 实现的方式没有类的单继承的局限性
*     2. 实现的方式更适合处理多个线程有共享数据的情况
* */


public class NewThread2ByRunnable {
  public static void main(String[] args) {
    MThread mThread = new MThread();
    Thread thread = new Thread(mThread);
    thread.start();
  }
}

class MThread implements Runnable{
  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      System.out.println(i);
    }
  }
}