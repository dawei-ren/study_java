package com.rendawei.builder;

/**
 * ConcreteBuilder.java
 *  具体建造者(工人)
 */
public class ConcreteBuilder implements Builder {
  private final Product product;
  public ConcreteBuilder() {
    product = new Product();
  }


  @Override
  public void bulidA() {
    product.setBuildA("地基");
  }

  @Override
  public void bulidB() {
    product.setBuildB("钢筋工程");
  }

  @Override
  public void bulidC() {
    product.setBuildC("铺电线");
  }

  @Override
  public void bulidD() {
    product.setBuildD("粉刷");
  }

  @Override
  public Product getProduct() {
    return product;
  }
}
