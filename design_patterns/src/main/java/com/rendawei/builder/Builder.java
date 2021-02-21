package com.rendawei.builder;

/**
 * Builder.java
 *  建造者
 */

public interface Builder {
  public void bulidA();
  //钢筋工程
  public void bulidB();
  //铺电线
  public void bulidC();
  //粉刷
  public void bulidD();
  //完工-获取产品
  abstract Product getProduct();
}




