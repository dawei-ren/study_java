package com.rendawei.strategy;

public class Duck {
  private final FlyStrategy flyStrategy;
  private final String name;

  public Duck(FlyStrategy flyStrategy, String name) {
    this.flyStrategy = flyStrategy;
    this.name = name;
  }

  public void fly(){
    System.out.println("我是："+ name);
    flyStrategy.fly();
  }
}
