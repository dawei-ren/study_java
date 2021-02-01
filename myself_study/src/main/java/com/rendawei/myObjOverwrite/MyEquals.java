package com.rendawei.myObjOverwrite;


/*
* equals 方法用来判断两个对象是否相等
* equals 方法默认使用的是 == 来判断
*
*
* */

public class MyEquals {

  public static void main(String[] args) {
    Person tom = new Person("Tom", 18);
    Person tom1 = new Person("Tom", 20);
    System.out.println(tom.equals(tom1));
  }
}


class Person {

  public String name;
  public int age;
  Person(String name, int age){
    this.name = name;
    this.age = age;
  }

  @Override
  public boolean equals(Object obj) {
    // 首选判断这对象是不是这个类的实例，如果不是，直接返回false
    if (!(obj instanceof Person)){
      return false;
    }
    Person person = (Person) obj;
    return this.name.equals(person.name);
  }
}
