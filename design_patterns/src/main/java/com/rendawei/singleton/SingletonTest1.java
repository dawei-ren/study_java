package com.rendawei.singleton;


/*
* 饿汉式
*
* 缺点： 可以使用，但是通过静态方法写的话，如果一次都不适用，可能造成内存浪费
*
* */

public class SingletonTest1 {

  public static void main(String[] args) {
    Singleton1 singleton1 = Singleton1.getInstance();
    Singleton1 singleton2 = Singleton1.getInstance();

//    此时会发现两个对象实际上是一个

    System.out.println(singleton1.hashCode());
    System.out.println(singleton2.hashCode());

  }


};


class Singleton1 {
  private Singleton1() {
  }

  private final static Singleton1 instance = new Singleton1();

  public static Singleton1 getInstance(){
    return instance;
  }
}