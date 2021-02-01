package com.rendawei.singleton;


/*
 * 懒汉式（线程安全）
 *
 * 只用在使用getInstance，方法的时候才创建
 *
 * 缺点：
 * 虽然线程安全了，但是效率太低了，每次都要判断
 *
 *
 * */

public class SingletonTest3 {

  public static void main(String[] args) {
    Singleton3 singleton1 = Singleton3.getInstance();
    Singleton3 singleton2 = Singleton3.getInstance();

//    此时会发现两个对象实际上是一个

    System.out.println(singleton1.hashCode());
    System.out.println(singleton2.hashCode());

  }


};


class Singleton3 {
  private Singleton3() {
  }

  private static Singleton3 instance;

  public static synchronized Singleton3 getInstance(){
    if (instance == null){
      instance = new Singleton3();
    }
    return instance;
  }
}
