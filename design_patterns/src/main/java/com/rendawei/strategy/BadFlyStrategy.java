package com.rendawei.strategy;

public class BadFlyStrategy implements FlyStrategy {

  @Override
  public void fly() {
    System.out.println("I can fly low");
  }
}
