package com.rendawei.comparable;


/*
 * Comparable 接口的使用举例： 自然排序，就是默认排序的方法
 *
 * 1. 像String。包装类等实现了Comparable接口，重写了compareTo 方法，给出了比较两个对象大小的规则
 * 2. 像String、包装类重写了compareTo 方法以后，进行了从小到大的排序
 * 3. 重写compareTo 的规则
 *     如果当前对象this大于形参对象obj，则返回正整数
 *     如果当前对象this小于形参对象obj，则返回负整数
 *     如果当前对象this等于形参对象obj，则返回零
 *
 * 4. 对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)方法，在compareTo方法中指明如何排序
 *
 * Comparator 接口的使用： 定制排序
 * 1. 当元素的类型没有实现Comparable接口而又不方便修改代码，或者实现了Comparable接口的排序规则不适合当前的操作，就用Comparator的对象来排序
 * 2. 重写compare(Object o1， Object o2)方法，比较o1和o2的大小：
 *      如果方法返回正整数，则表示o1 大于o2
 *      如果方法返回0， 表示相等
 *      如果返回负整数，表示o1 小于o2
 *
 *
 * */
public class Goods implements Comparable{
  private  String name;
  private double price;

  public Goods() {
  }

  public Goods(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "CompareGoods{" +
        "name='" + name + '\'' +
        ", price=" + price +
        '}';
  }

  // 指明商品比较大小的方式
  public int compareTo(Object o) {
    if (o instanceof Goods){
      Goods goods = (Goods) o;
      if (this.price > goods.price){
        return 1;
      }else if (this.price < goods.price){
        return -1;
      }else {
        return 0;
      }
    }
    throw new RuntimeException("传入的数据类型不一致");
  }
}
