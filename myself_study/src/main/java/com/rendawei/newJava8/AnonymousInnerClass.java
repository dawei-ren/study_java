package com.rendawei.newJava8;


/*
*
*   匿名内部类
*       如果有一个接口A 一个实现类B，在使用这个实现类B的时候发现只使用了一次，并且不需要频繁更换，就直接可以使用匿名内部类替换
*
*
* */


import com.rendawei.newJava8.baseClass.Child;
import com.rendawei.newJava8.baseClass.Person;

public class AnonymousInnerClass {
  public static void main(String[] args) {
    Person p = new Child();
    p.eat();

    // 上面代码Child只使用了一次，还要专门写一个类，就很麻烦，此时引入了匿名内部类

    Person p1 = new Person() {
      @Override
      public void eat() {
        System.out.println("aaa eat something");
      }
    };

    p1.eat();
  }

}

