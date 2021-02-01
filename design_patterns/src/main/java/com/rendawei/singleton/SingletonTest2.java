package com.rendawei.singleton;


/*
 * 懒汉式（线程不安全）
 *
 * 只用在使用getInstance，方法的时候才创建
 *
 * 缺点：
 *  只能在单线程下使用，如果有一个线程正在执行if (instance == null){这条语句，还未来得及执行吓一跳语句的时候，另一个线程通过了判断语句，这样会
 *  创造两个实例
 *
 * */

public class SingletonTest2 {

  public static void main(String[] args) {
    Singleton2 singleton1 = Singleton2.getInstance();
    Singleton2 singleton2 = Singleton2.getInstance();

//    此时会发现两个对象实际上是一个

    System.out.println(singleton1.hashCode());
    System.out.println(singleton2.hashCode());

  }


};


class Singleton2 {
  private Singleton2() {
  }

  private static Singleton2 instance;

  public static Singleton2 getInstance(){
    if (instance == null){
      instance = new Singleton2();
    }
    return instance;
  }
}
