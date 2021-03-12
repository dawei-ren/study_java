package com.rendawei.myClass;


/*
*   类的多构造器使用方法
*
*
* */


public class MoreConstruction {
  private final String name;
  private final int age;
  private long a;

  public MoreConstruction(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public MoreConstruction(int age) {
    this("Tom", 12);
  }

  @Override
  public String toString() {
    System.out.println(a);

    return "MoreConstruction{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}
