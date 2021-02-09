package com.rendawei.strategy;

public class Clint {
  public static void main(String[] args) {

    /*
    *
    * 可以再创建鸭子对象的时候传入不同的策略，来实现不同的效果，这个就是策略模式
    *
    *
    * \*/
    Duck wildDuck = new Duck(new GoodFlyStrategy(), "野鸭");
    wildDuck.fly();

    Duck pekingDuck = new Duck(new BadFlyStrategy(), "北京鸭");
    pekingDuck.fly();

    Duck toyDuck = new Duck(new NotFlyStrategy(), "玩具");
    toyDuck.fly();
  }
}
