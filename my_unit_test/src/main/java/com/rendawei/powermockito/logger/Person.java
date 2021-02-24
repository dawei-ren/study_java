package com.rendawei.powermockito.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Person {
  private static final Logger logger = LoggerFactory.getLogger(Person.class);

  private final String name;
  private final int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void sayHi(){
    if (age < 0){
      logger.error("age error");
    }

    System.out.println("Hi my name is " + name + " I am " + age + " years old!");
  }
}
