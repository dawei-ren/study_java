package com.rendawei.strategy;

public class GoodFlyStrategy implements FlyStrategy{
  @Override
  public void fly() {
    System.out.println("I can fly high");
  }
}
