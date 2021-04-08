package com.rendawei.optimizeCode;


/*
*   类的多构造器使用方法
*
*
* */

/**
 * 使用多构造器的优化可以在不改变之前的代码的情况下修改类
 *
 * 一般适用于原来构造器使用太多不好修改的情况下
 */
public class OptimizeAboutMoreConstruction {
  private final String name;
  private final int age;
  private long a;

  public OptimizeAboutMoreConstruction(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public OptimizeAboutMoreConstruction(int age) {
    this("Tom", age);
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
