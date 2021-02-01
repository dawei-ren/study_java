package com.rendawei.myObjOverwrite;



/*
*
* toString  : 打印对象，默认打印对象地址，可以通过重写此方法来自定义返回内容
*
*
* */

public class MyToString {
  public static void main(String[] args) {
    Person1 person1 = new Person1("Tom", 11);
    System.out.println(person1.toString());
  }
}



class Person1 {

  public String name;
  public int age;

  Person1(String name, int age){
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "name: " + this.name + "  age: " + this.age;
  }
}
