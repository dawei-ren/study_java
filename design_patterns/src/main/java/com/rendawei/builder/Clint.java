package com.rendawei.builder;

/**
 * Test.java
 *  测试类
 */
public class Clint {
  public static void main(String[] args) {
    Director director = new Director();
    Product product = director.create(new ConcreteBuilder());
    System.out.println(product.toString());
  }
}
