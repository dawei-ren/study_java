package com.rendawei.strategy;

public class NotFlyStrategy implements FlyStrategy {
  @Override
  public void fly() {
    System.out.println("I can not fly");
  }
}
